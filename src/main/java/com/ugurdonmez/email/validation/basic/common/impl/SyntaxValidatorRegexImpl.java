package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.SyntaxValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Syntax validator which use regex
 * 
 * @author ugurdonmez
 */
public class SyntaxValidatorRegexImpl implements SyntaxValidator {

    /**
     * Check email syntax
     * 
     * @param email
     * @return 
     */
    public boolean isSyntaxCorrect(String email) {
        
        if (email == null) {
            return false;
        }
        
        // TODO: fix regex
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern .matcher(email);
        return matcher.find();
    }
}
