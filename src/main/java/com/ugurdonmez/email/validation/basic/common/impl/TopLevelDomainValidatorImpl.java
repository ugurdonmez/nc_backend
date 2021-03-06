package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidator;
import com.ugurdonmez.email.validation.basic.data.GenericDomainsStorage;

/**
 * Class to validate top level domains by using trie structure populated by resource/generic_domains.txt
 * 
 * @author ugurdonmez
 */
public class TopLevelDomainValidatorImpl implements TopLevelDomainValidator {
    
    public boolean isTopLevelDomainCorrect(String topLevelDomain) {
        
        if (topLevelDomain == null) {
            return false;
        }
        
        // empty top level domain is valid
        if (topLevelDomain.equals("")) {
            return true;
        }
        
        return GenericDomainsStorage.getInstance().isIncludeGenericDomain(topLevelDomain);
    }
    
}
