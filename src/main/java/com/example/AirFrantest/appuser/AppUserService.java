package com.example.AirFrantest.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private  final AppUserRepository appUserRepository;
    private static String ERROR_USER;

    @Override
    public UserDetails loadUserByUsername(String countryOfResidence) throws UsernameNotFoundException {
        return appUserRepository.findBy(firstName).orElseThrow(() -> new UsernameNotFoundException(String.format(ERROR_USER, firstName)));
    }

    public String signUpUser(AppUser appUser) {
        return "";
    }
}
