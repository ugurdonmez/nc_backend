package com.ugurdonmez.email.validation.basic.common;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public abstract class TopLevelDomainValidatorTest<T extends TopLevelDomainValidator> {
    
    T topLevelDomainValidator;
    
    protected abstract T createInstance();
    
    @Before
    public void setUp() {
        topLevelDomainValidator = createInstance();
    }
    
    @Test
    public void test1() {
        assertTrue("should include", topLevelDomainValidator.isTopLevelDomainCorrect("aaa"));
    }
    
    @Test
    public void test2() {
        assertTrue("should include", topLevelDomainValidator.isTopLevelDomainCorrect("accountant"));
    }
    
    @Test
    public void test3() {
        assertTrue("should include", topLevelDomainValidator.isTopLevelDomainCorrect("youtube"));
    }
    
    @Test
    public void test4() {
        assertFalse("should not include", topLevelDomainValidator.isTopLevelDomainCorrect("xxxxxxxxxxx"));
    }
    
    @Test
    public void test5() {
        assertFalse("should not include", topLevelDomainValidator.isTopLevelDomainCorrect("ccccccccc"));
    }
    
    @Test
    public void test6() {
        assertFalse("should not include", topLevelDomainValidator.isTopLevelDomainCorrect("aaaa"));
    }
    
}
