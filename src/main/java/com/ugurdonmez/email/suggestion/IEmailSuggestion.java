package com.ugurdonmez.email.suggestion;


/**
 *
 * @author ugurdonmez
 */
public interface IEmailSuggestion {
    
    EmailSuggestionResult getEmailSuggestions(String email);
    
}
