package com.ugurdonmez.email.validation.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ugurdonmez
 */
public abstract class SyntaxValidatorTest<T extends SyntaxValidator>{
    
    protected T syntaxValidator;
    
    protected abstract T createInstance();
    
    @Before 
    public void setUp() {
        syntaxValidator = createInstance();
    }
    
    @Test
    public void testNoDomain() {
        String emailAddr = "abc.com";
        System.out.println(emailAddr);
        assertFalse("missing domain", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testNoLocalName() {
        String emailAddr = "@abc.com";
        System.out.println(emailAddr);
        assertFalse("missing local name", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testNonAllowdChar1() {
        String emailAddr = "asd\\@abc.com";
        System.out.println(emailAddr);
        assertFalse("not allowd char \\", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testNonAllowdChar2() {
        String emailAddr = "asd\"@abc.com";
        System.out.println(emailAddr);
        assertFalse("not allowd char \"", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testStartWithDot() {
        String emailAddr = ".asd@abc.com";
        System.out.println(emailAddr);
        assertFalse("start with dot not allowed", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testEndWithDot() {
        String emailAddr = "asd.@abc.com";
        System.out.println(emailAddr);
        assertFalse("end with dot not allowed", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testEmpty() {
        String emailAddr = "";
        System.out.println(emailAddr);
        assertFalse("empty email address", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testValid1() {
        String emailAddr = "asd@abc.com";
        System.out.println(emailAddr);
        assertTrue("valid email address", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
    
    @Test
    public void testValid2() {
        String emailAddr = "asd!#$%&'*+-/=?^_`{|}~@abc.com";
        System.out.println(emailAddr);
        assertTrue("valid email address", syntaxValidator.isSyntaxCorrect(emailAddr));
    }
}
