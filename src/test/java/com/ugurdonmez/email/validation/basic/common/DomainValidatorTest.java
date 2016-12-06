package com.ugurdonmez.email.validation.basic.common;

import org.junit.Before;


/**
 *
 * @author ugurdonmez
 */
public abstract class DomainValidatorTest <T extends DomainValidator>{
    
    T domainValidator;
    
    protected abstract T createInstance();
    
    @Before
    public void setUp() {
        domainValidator = createInstance();
    }
}
