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

    @Test
    public void testIsValidEmail() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.com"));
    }
    
    @Test
    public void testIsValidEmail1() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.com.tr"));
    }
    
    @Test
    public void testIsValidEmail2() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@unibz.it"));
    }
    
    @Test
    public void testIsValidEmail3() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@yahoo.co.uk"));
    }
    
    @Test
    public void testIsValidEmail4() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@aol.com"));
    }
    
    @Test
    public void testIsValidEmail5() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@att.net"));
    }
    
    @Test
    public void testIsValidEmail6() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.ru"));
    }
    
    @Test
    public void testIsValidEmailDomainNotFound() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, false, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@asdasd.net"));
    }
    
    @Test
    public void testIsValidEmailDomainNotFound1() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, false, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@asdasd.net.tr"));
    }
    
    @Test
    public void testIsValidEmailDomainNotFound2() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, false, true, true);
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@asdasd.it"));
    }
    
    @Test
    public void testIsValidEmailTopDomainNotFound() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, false, true);
        EmailValidationResult expectedResult1 = emailValidationService.isValidEmail("abcde@gmail.nettt");
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.nettt"));
    }

    
    @Test
    public void testIsValidEmailTopDomainNotFound1() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, false, true);
        EmailValidationResult expectedResult1 = emailValidationService.isValidEmail("abcde@gmail.nettt.tr");
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.nettt.tr"));
    }
    
    @Test
    public void testIsValidEmailCountryNotFound() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, false, false);
        EmailValidationResult expectedResult1 = emailValidationService.isValidEmail("abcde@gmail.com.trrrr");
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.nettt"));
    }

    
    @Test
    public void testIsValidEmailCountryNotFound1() {        
        EmailValidationResult expectedResult = new EmailValidationResult(true, true, false, false);
        EmailValidationResult expectedResult1 = emailValidationService.isValidEmail("abcde@gmail.commm.trrrr");
        
        assertEquals(expectedResult, emailValidationService.isValidEmail("abcde@gmail.nettt.tr"));
    }
    
}
