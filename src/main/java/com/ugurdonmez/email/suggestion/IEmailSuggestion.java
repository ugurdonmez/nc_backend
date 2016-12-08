package com.ugurdonmez.email.suggestion;


/**
 * Email suggestion interface
 * 
 * @author ugurdonmez
 */
public interface IEmailSuggestion {
    
    /**
     * Get email and correct email address
     * 
     * @param email String
     * @return EmailSuggestionResult
     */
    EmailSuggestionResult getEmailSuggestions(String email);
    
}
