package com.sobytylnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import com.sobytylnik.exception.EntityAlreadyExistsException;
import com.sobytylnik.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
//@Repository
public class InMemoryProfileRepository implements ProfileRepository {

    private ConcurrentHashMap<Long, Profile> map = new ConcurrentHashMap<>();

    @Override
    public Optional<Profile> findById(Long id) {

        if (map.containsKey(id)) {
            Profile a = map.get(id);

            return Optional.of(a);
        }
        return Optional.empty();
    }

    /**
     * @throws EntityAlreadyExistsException
     */
    @Override
    public Profile save(Profile profile) {
        if (profile.getId() != null && map.containsKey(profile.getId())) {
            throw new EntityAlreadyExistsException("There is such Profile in the base");
        }
        Long id = new Random().nextLong();
        profile.setId(id);
        map.put(id, profile);
        return profile;
    }

    /**
     * @throws EntityNotFoundException
     */
    @Override
    public void merge(Profile profile) {
        if (!map.containsKey(profile.getId())) {
            throw new EntityNotFoundException("There is no such Profile in the base, try not merge but save option");
        }
        map.put(profile.getId(), profile);
    }

    /**
     * @throws EntityNotFoundException
     */
    @Override
    public void deleteById(long id){
        if (!map.containsKey(id)) {
            throw new EntityNotFoundException("There is no such Profile in the base, it is already deleted, or never existed");
        }
        map.remove(id);
    }

    @Override
    public List<Profile> findAllProfiles() {
        return new ArrayList<>(map.values());
    }

    @Override
    public String toString() {
        return "InMemoryProfileRepository{" +
                "map=" + map +
                '}';
    }
}
