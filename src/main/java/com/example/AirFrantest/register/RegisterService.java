package com.example.AirFrantest.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private ValidatorCountry validatorCountry;

    public String registration(RegisterRequest request) {
      boolean isValidCountry=  validatorCountry.test(request.getCountryOfResidence());
       if(!isValidCountry){
           throw new IllegalStateException("Country of residence not valid");
       }
        return "well done";
    }
}
