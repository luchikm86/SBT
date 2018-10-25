package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api/profiles")
public class ProfileController {

//    @Autowired
    private ProfileRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        return repository.findAllProfiles();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Profile> getProfileByID(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Profile createProfile(@RequestBody Profile newProfile) {
        return repository.save(newProfile);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Optional<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile newProfile) {
        newProfile.setId(id);
        repository.merge(newProfile);
        return repository.findById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
