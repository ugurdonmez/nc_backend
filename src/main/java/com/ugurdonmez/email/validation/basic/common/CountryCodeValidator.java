package com.ugurdonmez.email.validation.basic.common;

/**
 *
 * Interface for control country code in domain
 * 
 * ref: http://www.iana.org/domains/root/db
 * 
 * @author ugurdonmez
 */
public interface CountryCodeValidator {
    
    /**
     * Method to check country code is valid or not
     * 
     * @param String country code
     * @return boolean
     */
    boolean isCountryCodeCorrect(String countryCode);
    
}
