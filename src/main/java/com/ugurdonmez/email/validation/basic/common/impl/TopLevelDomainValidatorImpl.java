package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidator;
import com.ugurdonmez.email.validation.basic.data.GenericDomainsStorage;

/**
 * 
 * @author ugurdonmez
 */
public class TopLevelDomainValidatorImpl implements TopLevelDomainValidator {

    public boolean isTopLevelDomainCorrect(String topLevelDomain) {
        return GenericDomainsStorage.getInstance().isIncludeGenericDomain(topLevelDomain);
    }
    
}
