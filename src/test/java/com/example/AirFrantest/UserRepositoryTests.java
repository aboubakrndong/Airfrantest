package com.example.AirFrantest;

import com.example.AirFrantest.model.AppUser;
import com.example.AirFrantest.repository.AppUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import java.util.Calendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private AppUserRepository repo;

    @Autowired
    private TestEntityManager entityManager ;

    @Test
    public void testCreateUser(){

        Calendar cal = Calendar.getInstance();
        cal.set(1994,1,8);

        AppUser appUser = new AppUser();

        appUser.setFirstName("BOOBA");
        appUser.setLastName("DIOuf");
        appUser.setPassword("Passer173");
        appUser.setBirthDate(1939,Calendar.JANUARY,8);
        appUser.setCountryOfResidence("France");
        appUser.setPhoneNumber("+33192520733");
        appUser.setGender("MALE");

        AppUser savedUser = repo.save(appUser);

        // AppUser existUser = entityManager.find(AppUser.class, savedUser.getId());

        Assertions.assertThat(savedUser.getLastName()).isEqualTo(appUser.getLastName());
    }

    @Test
    public void testFindUserByLastName(){
        String lastName = "DIOP";
        Optional<AppUser> findAppUser = repo.findByLastName(lastName);
        assertThat(repo.findByLastName(lastName)).isNotNull();
    }

    




}
