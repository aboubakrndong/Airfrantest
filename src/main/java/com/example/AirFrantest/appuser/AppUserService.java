package com.example.AirFrantest.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private  final AppUserRepository appUserRepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static String ERROR_USER;

    @Override
    public UserDetails loadUserByUsername(String countryOfResidence) throws UsernameNotFoundException {
        return appUserRepository.findByCountryOfResidence(countryOfResidence).orElseThrow(() -> new UsernameNotFoundException(String.format(ERROR_USER, countryOfResidence)));
    }

    public String registerUser(AppUser appUser) {
       boolean userExists = appUserRepository.findByCountryOfResidence(appUser.getCountryOfResidence())
                .isPresent();

       if (userExists) {
           throw new IllegalStateException("Country of residence not valid");
       }

       String passwordCrypted = bCryptPasswordEncoder.encode(appUser.getPassword());

       appUser.setPassword(passwordCrypted);

       appUserRepository.save(appUser);

       return "Waouh good job";

    }
}