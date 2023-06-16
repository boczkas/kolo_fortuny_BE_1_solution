package com.example.kolo_fortuny.password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PasswordController {

    private final PasswordRepository passwordRepository;
    private final PasswordService passwordService;

    public PasswordController(
      PasswordRepository passwordRepository, PasswordService passwordService) {
    this.passwordRepository = passwordRepository;
    this.passwordService = passwordService;
    }

    @GetMapping("/password")
    @ResponseBody
    public Password getPassword() throws NoSuchAlgorithmException {
        passwordService.setRandomPassword();
        passwordService.setCurrentGuess(
                passwordService.getPasswordText().replaceAll("(\\w)", "*"));
        return passwordService.getCurrentGuess();
    }

    @PostMapping("/guess")
    @ResponseBody
    public Password guess(@RequestBody String letter) {
        passwordService.updateCurrentGuess(letter);

        return passwordRepository.getCurrentGuess();
    }

    @PostMapping("/guess/password")
    @ResponseBody
    public boolean guessPassword(@RequestBody String password) {
        return passwordService.isPasswordCorrect(password);
    }
}
