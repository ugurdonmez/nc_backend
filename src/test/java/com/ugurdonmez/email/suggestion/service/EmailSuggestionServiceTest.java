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
        EmailSuggestionResult result = emailSuggestionService.getSuggestions("");
    }
    
}
