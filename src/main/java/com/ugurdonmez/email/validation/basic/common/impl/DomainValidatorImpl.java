package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.DomainValidator;
import com.ugurdonmez.email.validation.basic.data.DomainsStorage;

/**
 *
 * @author ugurdonmez
 */
public class DomainValidatorImpl implements DomainValidator{

    public boolean isDomainCorrect(String domain) {
        return DomainsStorage.getInstance().isIncludeDomain(domain);
    }
}
