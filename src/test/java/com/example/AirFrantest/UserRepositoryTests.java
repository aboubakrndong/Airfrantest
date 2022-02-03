package com.example.AirFrantest;

import com.example.AirFrantest.appuser.AppUser;
import com.example.AirFrantest.appuser.AppUserRepository;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import java.util.Calendar;
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

        appUser.setFirstName("Alioune");
        appUser.setLastName("DIOP");
        appUser.setPassword("Passer173");
        appUser.setBirthDate(1969,Calendar.JANUARY,9);
        appUser.setCountryOfResidence("France");
        appUser.setPhoneNumber("+33199220733");
        appUser.setGender("MALE");

        AppUser savedUser = repo.save(appUser);

        // AppUser existUser = entityManager.find(AppUser.class, savedUser.getId());

        Assertions.assertThat(savedUser.getCountryOfResidence()).isEqualTo("France");








    }



}
