package com.example.AirFrantest.register;

import com.example.AirFrantest.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="userapi/v1/register")


@AllArgsConstructor
public class RegisterController {
    private final RegisterService registerService;
@PostMapping(path="userapi/v1/")
@GetMapping(path="userapi/v1/{lastName}")
@PutMapping(path = "userapi/v1/{lastName}")
    public String registration(@RequestBody RegisterRequest request) {
        return registerService.registration(request);
    }
}


