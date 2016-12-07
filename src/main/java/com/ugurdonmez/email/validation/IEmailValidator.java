package com.ugurdonmez.email.validation;

/**
 *
 * @author ugurdonmez
 */
public interface IEmailValidator {
    EmailValidationResult isValidEmail(String email);
}
