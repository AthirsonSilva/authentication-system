package com.authenticationsystem.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {
        String regex = "^(.+)@(.+).(.+)$";

        return email.matches(regex);
    }

}
