package com.example.kolo_fortuny.password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Controller
public class PasswordController {

    private Random rand = SecureRandom.getInstanceStrong();

    public PasswordController() throws NoSuchAlgorithmException {
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/password")
    @ResponseBody
    public String getPassword() {
        List<String> passwords = WordList.getWORDS();
        int index = rand.nextInt(passwords.size());
        return passwords.get(index);
    }

}
