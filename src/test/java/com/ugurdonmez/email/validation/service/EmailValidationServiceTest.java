/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.email.validation.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationServiceTest {
    
    EmailValidationService emailValidationService;
        
    public EmailValidationServiceTest() {
        Injector injector = Guice.createInjector(new EmailValidationBasicModule());
        emailValidationService = injector.getInstance(EmailValidationService.class);
    }

    /**
     * Test of isValidEmail method, of class EmailValidationService.
     */
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        assertTrue(emailValidationService.isValidEmail("abc@gmail.com"));
    }
    
}
