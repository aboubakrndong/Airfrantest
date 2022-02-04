package com.example.AirFrantest.register;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class ValidatorLastName implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //TODO: Regex
        return true;
    }
}
