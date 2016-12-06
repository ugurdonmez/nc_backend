package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.DomainValidatorTest;

/**
 *
 * @author ugurdonmez
 */
public class DomainValidatorImplTest extends DomainValidatorTest<DomainValidatorImpl>{

    @Override
    protected DomainValidatorImpl createInstance() {
        return new DomainValidatorImpl();
    }
    
}


