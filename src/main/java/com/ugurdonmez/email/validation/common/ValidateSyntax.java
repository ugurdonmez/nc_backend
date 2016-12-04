/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.email.validation.common;

import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author ugurdonmez
 */
public class ValidateSyntax {
    
    public static boolean validate (String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        
        return emailValidator.isValid(email);
    }
    
}
