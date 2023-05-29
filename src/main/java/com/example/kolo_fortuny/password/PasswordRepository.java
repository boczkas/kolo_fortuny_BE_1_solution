package com.example.kolo_fortuny.password;

import org.springframework.stereotype.Repository;

@Repository
public class PasswordRepository {

    Password password;
    Password currentGuess;

    public void setPassword(Password password) {
        this.password = password;
        this.currentGuess = password;
    }
}
