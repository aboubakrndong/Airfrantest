package com.example.AirFrantest.repository;

import com.example.AirFrantest.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional (readOnly= true)
public interface AppUserRepository  extends JpaRepository<AppUser, Long> {

    @Query(" SELECT u from AppUser u where u.lastName = ?1")
    Optional<AppUser> findByLastName(String lastName);

}
