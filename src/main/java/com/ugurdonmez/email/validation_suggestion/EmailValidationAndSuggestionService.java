package com.ugurdonmez.email.validation_suggestion;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.suggestion.basic.EmailSuggestionBasicModule;
import com.ugurdonmez.email.suggestion.service.EmailSuggestionService;
import com.ugurdonmez.email.validation.EmailValidationResult;
import com.ugurdonmez.email.validation.basic.EmailValidatorBasicModule;
import com.ugurdonmez.email.validation.service.EmailValidationService;

/**
 * Service for validate and suggest
 * 
 * @author ugurdonmez
 */
public class EmailValidationAndSuggestionService {
    
    private EmailValidationService emailValidationService;
    private EmailSuggestionService emailSuggestionService;
    
    /**
     * Inject validation and suggestion services
     */
    public EmailValidationAndSuggestionService() {
        Injector injectorValidationModule = Guice.createInjector(new EmailValidatorBasicModule());
        emailValidationService = injectorValidationModule.getInstance(EmailValidationService.class);
        
        Injector injectorSuggestionModule = Guice.createInjector(new EmailSuggestionBasicModule());
        emailSuggestionService = injectorSuggestionModule.getInstance(EmailSuggestionService.class);
    }
    
    /**
     * validate and suggest method
     * 
     * @param email
     * @return EmailValidationAndSuggestionResult
     */
    public EmailValidationAndSuggestionResult validateSuggest(String email) {
        
        EmailValidationResult emailValidationResult = emailValidationService.isValidEmail(email);
        EmailSuggestionResult emailSuggestionResult;
        
        if (!emailValidationResult.isIsSyntaxCorrect()) {
            emailSuggestionResult = new EmailSuggestionResult();
        } else {
            emailSuggestionResult = emailSuggestionService.getSuggestions(email);
        }
        
        return new EmailValidationAndSuggestionResult(emailValidationResult, emailSuggestionResult);
    }
}
