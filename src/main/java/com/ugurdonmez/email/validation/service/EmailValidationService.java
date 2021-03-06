package com.ugurdonmez.email.validation.service;

import com.google.inject.Inject;
import com.ugurdonmez.email.validation.EmailValidationResult;
import com.ugurdonmez.email.validation.IEmailValidator;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationService {
    
    private final IEmailValidator emailValidator;
    
    @Inject
    public EmailValidationService(IEmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }
    
    public EmailValidationResult isValidEmail(String email) {
        return emailValidator.isValidEmail(email);
    }
}
