package com.example.AirFrantest.register;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
@Getter
@AllArgsConstructor

public class RegisterRequest {

    private final String firstName;
    private final String lastName;
    private final String countryOfResidence;
    private final String phoneNumber;
    private final String password;
    private final Date birthDate;
    private final String gender;

}
