package com.ugurdonmez.email.validation.common.impl;

import com.ugurdonmez.email.validation.common.SyntaxValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author ugurdonmez
 */
public class SyntaxValidatorRegexImpl implements SyntaxValidator {

    public boolean isSyntaxCorrect(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern .matcher(email);
        return matcher.find();
    }
}
