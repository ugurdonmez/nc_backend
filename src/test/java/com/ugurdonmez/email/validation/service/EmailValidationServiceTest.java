package com.ugurdonmez.email.validation.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ugurdonmez.email.validation.EmailValidationResult;
import com.ugurdonmez.email.validation.basic.EmailValidatorBasicModule;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationServiceTest {
    
    EmailValidationService emailValidationService;
        
    public EmailValidationServiceTest() {
        Injector injector = Guice.createInjector(new EmailValidatorBasicModule());
        emailValidationService = injector.getInstance(EmailValidationService.class);
    }

    /**
     * Test of isValidEmail method, of class EmailValidationService.
     */
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.com"));
    }
    
}
