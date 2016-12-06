package com.ugurdonmez.email.validation.basic.common;

/**
 *
 * Interface for control common domain
 * 
 * 
 * @author ugurdonmez
 */
public interface DomainValidator {
 
    /**
     * Method to check domain is valid or not
     * 
     * @param String domain
     * @return boolean
     */
    boolean isDomainCorrect(String domain);
    
}
