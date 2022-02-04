package com.example.AirFrantest.service;

import com.example.AirFrantest.model.AppUser;
import com.example.AirFrantest.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    @Autowired
    private  final AppUserRepository appUserRepository;

    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static String ERROR_USER;

    @Override
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
        return appUserRepository.findByLastName(lastName).orElseThrow(() -> new UsernameNotFoundException(String.format(ERROR_USER, lastName)));
    }

    public String registerUser(AppUser appUser) {
       boolean userExists = appUserRepository.findByLastName(appUser.getLastName())
                .isPresent();

       if (userExists) {
           throw new IllegalStateException("lastname not valid");
       }

       String passwordCrypted = bCryptPasswordEncoder.encode(appUser.getPassword());

       appUser.setPassword(passwordCrypted);

       appUserRepository.save(appUser);

       return "Waouh good job";
    }
}