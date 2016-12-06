package com.ugurdonmez.email.validation.basic.common;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


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
    
    @Test
    public void test1() {
        assertTrue("should include", domainValidator.isDomainCorrect("facebook"));
    }
    
    @Test
    public void test2() {
        assertTrue("should include", domainValidator.isDomainCorrect("tcnj"));
    }
}
