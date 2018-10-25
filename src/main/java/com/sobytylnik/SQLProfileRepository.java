//package com.sobytylnik;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface SQLProfileRepository extends JpaRepository<Profile, Long> {
//    @Override
//    Optional<Profile> findById(Long id);
//
//    Profile save(Profile profile);
//
//    void merge(Profile profile);
//
//    void deleteById(long id);
//
//    List<Profile> findAllProfiles();
//}
