package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidatorTest;
import com.ugurdonmez.email.validation.basic.common.impl.TopLevelDomainValidatorImpl;


/**
 *
 * @author ugurdonmez
 */
public class TopLevelDomainValidatorImplTest extends TopLevelDomainValidatorTest<TopLevelDomainValidatorImpl>{

    @Override
    protected TopLevelDomainValidatorImpl createInstance() {
        return new TopLevelDomainValidatorImpl();
    }
    
}
