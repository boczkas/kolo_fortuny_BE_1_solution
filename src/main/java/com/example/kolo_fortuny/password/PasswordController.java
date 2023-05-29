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
        Random rand = SecureRandom.getInstanceStrong();
        List<String> passwords = WordList.getWORDS();
        int index = rand.nextInt(passwords.size());
        String passwordText = passwords.get(index);
        System.out.println("Ustawiam haslo na " + passwordText);

        Password password = new Password(passwordText);
        passwordRepository.setPassword(password);
        Password replacedPassword = new Password(passwordText.replaceAll("(\\w)", "*"));
        passwordRepository.setCurrentGuess(replacedPassword);

        return replacedPassword;
    }

    @PostMapping("/guess")
    @ResponseBody
    public Password guess(@RequestBody String letter) {
        String passwordText = passwordRepository.getPassword().getText();
        if (passwordText.contains(letter)) {
            String updatedText =
                    passwordService.getUpdatedText(
                            passwordText, passwordRepository.getCurrentGuess().getText(), letter);
            passwordRepository.setCurrentGuess(new Password(updatedText));
        }

        return passwordRepository.getCurrentGuess();
    }

}
