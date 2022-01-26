package com.example.AirFrantest.register;

import com.example.AirFrantest.appuser.AppUser;
import com.example.AirFrantest.appuser.AppUserRole;
import com.example.AirFrantest.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final AppUserService appUserService;
    private final ValidatorCountry validatorCountry;

    public String registration(RegisterRequest request) {
      boolean isValidCountry=  validatorCountry.test(request.getCountryOfResidence());
       if(!isValidCountry){
           throw new IllegalStateException("Country of residence not valid");
       }
        return appUserService.registerUser(
                new AppUser (
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPassword(),
                        request.getBirthDate(),
                        request.getCountryOfResidence(),
                        request.getPhoneNumber(),
                        request.getGender(),
                        AppUserRole.USER
                )
        );
    }
}
