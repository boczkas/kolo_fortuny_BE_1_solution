package com.example.kolo_fortuny.password;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {
    public String getUpdatedText(String passwordText, String currentGuessText, String letter) {
        int index = passwordText.indexOf(letter);
        List<Integer> indexesOfLetter = new ArrayList<>();

        while (index >= 0) {
            indexesOfLetter.add(index);
            index = passwordText.indexOf(letter, index + 1);
        }

        StringBuilder stringBuilder = new StringBuilder(currentGuessText);
        for (int i : indexesOfLetter) {
            stringBuilder.setCharAt(i, letter.charAt(0));
        }

        return stringBuilder.toString();
    }
}
