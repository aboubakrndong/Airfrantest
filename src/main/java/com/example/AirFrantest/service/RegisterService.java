package com.example.AirFrantest.service;
import com.example.AirFrantest.model.AppUser;
import com.example.AirFrantest.appuser.AppUserRole;
import com.example.AirFrantest.register.RegisterRequest;
import com.example.AirFrantest.register.ValidatorLastName;
import com.example.AirFrantest.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final AppUserService appUserService;
    private final ValidatorLastName validatorLastName;

    public String registration(RegisterRequest request) {
      boolean isValidLastName=  validatorLastName.test(request.getLastName());
       if(!isValidLastName){
           throw new IllegalStateException("lastname not valid");
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
