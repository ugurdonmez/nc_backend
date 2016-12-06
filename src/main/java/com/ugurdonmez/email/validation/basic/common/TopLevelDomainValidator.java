package com.ugurdonmez.email.validation.basic.common;

/**
 *
 * Interface to check top level domains
 * 
 * ref: http://www.iana.org/domains/root/db
 * 
 * @author ugurdonmez
 */
public interface TopLevelDomainValidator {
    
    /**
     * Method to check top level domain(com, net ...etc) is valid or not
     * 
     * @param String country code
     * @return boolean
     */
    boolean isTopLevelDomainCorrect(String topLevelDomain);
    
}
