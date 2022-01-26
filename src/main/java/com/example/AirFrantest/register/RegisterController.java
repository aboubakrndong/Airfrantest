package com.example.AirFrantest.register;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="userapi/name/register")
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;
@PostMapping
    public String registration(@RequestBody RegisterRequest request) {
        return registerService.registration(request);
    }
}
