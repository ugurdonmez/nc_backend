package com.ugurdonmez.email.suggestion.service;

import com.google.inject.Inject;
import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.suggestion.IEmailSuggestion;

/**
 * 
 * 
 * @author ugurdonmez
 */
public class EmailSuggestionService {
    
    private final IEmailSuggestion emailSuggestion;
    
    @Inject
    public EmailSuggestionService(IEmailSuggestion emailSuggestion) {
        this.emailSuggestion = emailSuggestion;
    }
    
    public EmailSuggestionResult getSuggestions(String email) {
        return emailSuggestion.getEmailSuggestions(email);
    }
}
