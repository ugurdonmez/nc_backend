package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.SyntaxValidator;
import org.apache.commons.validator.EmailValidator;

/**
 * Syntax validator which use apache common library methods
 * 
 * @author ugurdonmez
 */
public class SyntaxValidatorApacheCommonImpl implements SyntaxValidator {

    /**
     * Check email syntax
     * 
     * @param email
     * @return 
     */
    public boolean isSyntaxCorrect(String email) {
        // get apache commin email validator
        EmailValidator emailValidator = EmailValidator.getInstance();
        
        return emailValidator.isValid(email);
    }
}
