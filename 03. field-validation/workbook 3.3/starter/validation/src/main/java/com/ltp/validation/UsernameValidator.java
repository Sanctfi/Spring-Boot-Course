package com.ltp.validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {
    // List<String> characters = Arrays.asList("$", "%", "#", "@", "^", "*");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // for (String character : characters) {
        //     if(value.contains(character)) return false;
        // }
        // return true;
        Pattern pattern = Pattern.compile("[^a-z0-9 ]");
        Matcher matcher = pattern.matcher(value);
        // line below is a little confusing, it returns true if the matcher's find method returns nothing. Returns false 
        // if it does come across a special character or uppercase
        return !matcher.find();
    }
}
