package com.ugurdonmez.email.validation_suggestion;

import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.validation.EmailValidationResult;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationAndSuggestionServiceTest {
    
    private EmailValidationAndSuggestionService service;
    
    public EmailValidationAndSuggestionServiceTest() {
        service = new EmailValidationAndSuggestionService();
    }
    
    @Test
    public void test() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcde@gmail.com");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, true, true);
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test1() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@gnail.com");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, false, true, true);
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        
        emailSuggestionResult.setDistance(1);
        emailSuggestionResult.addToSuggestions("abcd@gmail.com");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test2() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@gmail.comm");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, false, true);
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        
        emailSuggestionResult.setDistance(1);
        emailSuggestionResult.addToSuggestions("abcd@gmail.com");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test3() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@fibertel.com.ar");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, true, true);
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test4() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@fiberte.com.ar");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, false, true, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(2);
        emailSuggestionResult.addToSuggestions("abcd@fibertel.com.ar");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test5() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@fibertel.comm.ar");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, false, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(2);
        emailSuggestionResult.addToSuggestions("abcd@fibertel.com.ar");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test6() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@fibertel.comm.arr");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, false, false);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(2);
        emailSuggestionResult.addToSuggestions("abcd@fibertel.com.ar");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test7() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@tvcablenet.be");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, true, true);
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test8() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@tvvcablenet.bee");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, false, false, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(2);
        emailSuggestionResult.addToSuggestions("abcd@tvcablenet.be");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test9() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@tvcablenet.bee");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, true, false, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(1);
        emailSuggestionResult.addToSuggestions("abcd@tvcablenet.be");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test10() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@tvcabenet.be");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(true, false, true, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(2);
        emailSuggestionResult.addToSuggestions("abcd@tvcablenet.be");
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test11() {
        EmailValidationAndSuggestionResult result = service.validateSuggest("abcd@g");
        
        EmailValidationResult emailValidationResult = new EmailValidationResult(false, false, false, true);
        
        EmailSuggestionResult emailSuggestionResult = new EmailSuggestionResult();
        emailSuggestionResult.setDistance(0);
        
        EmailValidationAndSuggestionResult expected = new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
        
        assertEquals(expected, result);
    }
    
    
}
