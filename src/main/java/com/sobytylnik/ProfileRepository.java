package com.sobytylnik;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> findById(Long id);

    /**
     * @return the profile with generated id.
     */
    Profile save(Profile profile);

    void merge(Profile profile);

    void deleteById(long id);

    List<Profile> findAllProfiles();
}