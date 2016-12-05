package com.ugurdonmez.email.validation.common;

/**
 *
 * Interface for control country code in domain
 * 
 * ref: http://www.iana.org/domains/root/db
 * 
 * @author ugurdonmez
 */
public interface CountryCodeValidator {
    
    boolean isCountryCodeCorrect();
    
}
