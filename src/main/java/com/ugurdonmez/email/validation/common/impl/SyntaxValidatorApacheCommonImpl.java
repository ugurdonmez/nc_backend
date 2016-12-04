package com.ugurdonmez.email.validation.common.impl;

import com.ugurdonmez.email.validation.common.SyntaxValidator;
import org.apache.commons.validator.EmailValidator;

/**
 * Syntax validator which use apache common library methods
 * 
 * @author ugurdonmez
 */
public class SyntaxValidatorApacheCommonImpl implements SyntaxValidator {

    public boolean isSyntaxCorrect(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        
        return emailValidator.isValid(email);
    }
}
