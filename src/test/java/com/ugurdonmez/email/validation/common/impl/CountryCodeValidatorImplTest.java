package com.ugurdonmez.email.validation.common.impl;

import com.ugurdonmez.email.validation.basic.common.impl.CountryCodeValidatorImpl;
import com.ugurdonmez.email.validation.common.CountryCodeValidatorTest;

/**
 *
 * @author ugurdonmez
 */
public class CountryCodeValidatorImplTest extends CountryCodeValidatorTest<CountryCodeValidatorImpl>{

    @Override
    protected CountryCodeValidatorImpl createInstance() {
        return new CountryCodeValidatorImpl();
    }
}
