package com.ugurdonmez.email.suggestion.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.suggestion.basic.EmailSuggestionBasicModule;
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
public class EmailSuggestionServiceTest {
    
    private EmailSuggestionService emailSuggestionService;
        
    public EmailSuggestionServiceTest() {
        Injector injector = Guice.createInjector(new EmailSuggestionBasicModule());
        emailSuggestionService = injector.getInstance(EmailSuggestionService.class);
    }
    
    @Test
    public void test() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gmail.com");
        
        assertEquals(new EmailSuggestionResult(0), result);
    }
    
    @Test
    public void test1() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gnail.com");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test2() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gail.com");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@mail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test3() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gmail.c");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test4() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gmail.");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(2);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test5() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gmail.con");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test6() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@gma.con");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(2);
        expected.addToSuggestions("abcd@gmx.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test7() {
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("abcd@yahoo.co.u");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@yahoo.co.uk");
        
        assertEquals(expected, result);
    }
    
}
