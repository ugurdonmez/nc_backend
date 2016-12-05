package com.ugurdonmez.email.validation.common;

import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public abstract class CountryCodeValidatorTest <T extends CountryCodeValidator>{
    
    T countryCodeValitor;
    
    protected abstract T createInstance();
    
    @Before
    public void setUp() {
        countryCodeValitor = createInstance();
    }
    
    @Test
    public void test1(){
        
    }
}
