package com.example.demo.Utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

	private  final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private  final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private  final String NUMBER = "0123456789";
    private  final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private  final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    // optional, make it more random
    private  final String PASSWORD_ALLOW_BASE_SHUFFLE = shuffleString(PASSWORD_ALLOW_BASE);
    private  final String PASSWORD_ALLOW = PASSWORD_ALLOW_BASE_SHUFFLE;

    private static SecureRandom random = new SecureRandom();


    public  String generateRandomPassword(int length) {
        

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(PASSWORD_ALLOW.length());
            char rndChar = PASSWORD_ALLOW.charAt(rndCharAt);

            // debug
            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }

    // shuffle
    public  String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return letters.stream().collect(Collectors.joining());
    }

}
