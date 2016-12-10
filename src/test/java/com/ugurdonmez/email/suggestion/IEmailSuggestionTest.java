package com.ugurdonmez.email.suggestion;

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
public abstract class IEmailSuggestionTest <T extends IEmailSuggestion> {
    
    T emailSuggestion;
    
    protected abstract  T createInstance();
    
    @Before
    public void setUp() {
        emailSuggestion = createInstance();
    }
    
    @Test
    public void test() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gmail.com");
        
        assertEquals(new EmailSuggestionResult(0), result);
    }
    
    @Test
    public void test1() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gnail.com");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test2() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gail.com");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@mail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test3() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gmail.c");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test4() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gmail.");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(2);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test5() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gmail.con");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@gmail.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test6() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@gma.con");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(2);
        expected.addToSuggestions("abcd@gmx.com");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test7() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@yahoo.co.u");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(1);
        expected.addToSuggestions("abcd@yahoo.co.uk");
        
        assertEquals(expected, result);
    }
    
    @Test
    public void test8() {
        EmailSuggestionResult result = emailSuggestion.getEmailSuggestions("abcd@g");
        
        EmailSuggestionResult expected = new EmailSuggestionResult();
        expected.setDistance(3);
        expected.addToSuggestions("abcd@gmx.fr");
        expected.addToSuggestions("abcd@ya.ru");
        expected.addToSuggestions("abcd@gmx.net");
        expected.addToSuggestions("abcd@gmx.de");
        expected.addToSuggestions("abcd@gmx.com");
        
        assertEquals(expected, result);
    }
}
