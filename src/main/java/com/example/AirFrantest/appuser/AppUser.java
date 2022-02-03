package com.example.AirFrantest.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity

public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "the firstname can't be empty")
    private String firstName;

    @NotNull(message = "the lastname can't be empty")
    private String lastName;

    @NotNull(message = "password is mandatory")
    private String password;

    @Past(message = "The birthdate must be in the past ")
    @NotNull(message = "the birthdate must be higher than 18 years old, please type again")
    private Date birthDate;
    @Pattern(regexp = "^[a-zA-Z àâäèéêëîïôœùûüÿçÀÂÄÈÉŒÇ]+$", message = "the name of country can't have numeric or special characters is not allowed")
    private String countryOfResidence;

    @NotNull(message = "phonenumber is optional")
    private String phoneNumber;

    @Pattern(regexp = "(MALE|FEMALE|OTHER)$", message = "wrong type , please change")
    @NotNull(message = "gender is optional")
    private String gender;


    public AppUser(@NotNull(message = "the firstname can't be empty") String firstName,
                   @NotNull(message = "the lastname can't be empty") String lastName,
                   @NotNull(message = "password is mandatory") String password,
                   @Past(message = "The birthdate must be in the past ") @NotNull(message = "the birthdate must be higher than 18 years old, please type again") Date birthDate,
                   @Pattern(regexp = "^[a-zA-Z àâäèéêëîïôœùûüÿçÀÂÄÈÉŒÇ]+$", message = "the name of country can't have numeric or special characters is not allowed") String countryOfResidence,
                   @NotNull(message = "phonenumber is optional") String phoneNumber,
                   @Pattern(regexp = "(MALE|FEMALE|OTHER)$", message = "wrong type , please change") @NotNull(message = "gender is optional") String gender, AppUserRole user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.countryOfResidence = countryOfResidence;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(AppUserRole.USER.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getUsername() {
        return countryOfResidence;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

   /* public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }*/

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setBirthDate(int Year, int Month, int Day) {
        Calendar cal = Calendar.getInstance();
        cal.set( Year, Month, Day );
        this.birthDate = cal.getTime();
    }
}