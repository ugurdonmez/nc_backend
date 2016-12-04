package com.ugurdonmez.email.validation.common;

/**
 * Interface for checking email in correct syntax
 * 
 * Check that email contains only valid characters
 * Check that email contains both local part and domain
 * 
 * ref:https://tools.ietf.org/html/rfc5322
 * ref:https://tools.ietf.org/html/rfc5321
 * 
 * http://stackoverflow.com/questions/2049502/what-characters-are-allowed-in-email-address
 * 
 * @author ugurdonmez
 */
public interface SyntaxValidator {
    
    /**
     * Method for check email is in correct form
     * 
     * @param email
     * @return boolean
     */
    boolean isSyntaxCorrect(String email);
}
