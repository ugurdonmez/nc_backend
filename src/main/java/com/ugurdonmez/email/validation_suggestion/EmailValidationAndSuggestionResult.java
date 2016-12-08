package com.ugurdonmez.email.validation_suggestion;

import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.validation.EmailValidationResult;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationAndSuggestionResult {
    
    private final EmailValidationResult emailValidationResult;
    private final EmailSuggestionResult emailSuggestionResult;

    public EmailValidationAndSuggestionResult(EmailValidationResult emailValidationResult, EmailSuggestionResult emailSuggestionResult) {
        this.emailValidationResult = emailValidationResult;
        this.emailSuggestionResult = emailSuggestionResult;
    }

    public EmailValidationResult getEmailValidationResult() {
        return emailValidationResult;
    }

    public EmailSuggestionResult getEmailSuggestionResult() {
        return emailSuggestionResult;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.emailValidationResult != null ? this.emailValidationResult.hashCode() : 0);
        hash = 41 * hash + (this.emailSuggestionResult != null ? this.emailSuggestionResult.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmailValidationAndSuggestionResult other = (EmailValidationAndSuggestionResult) obj;
        if (this.emailValidationResult != other.emailValidationResult && (this.emailValidationResult == null || !this.emailValidationResult.equals(other.emailValidationResult))) {
            return false;
        }
        if (this.emailSuggestionResult != other.emailSuggestionResult && (this.emailSuggestionResult == null || !this.emailSuggestionResult.equals(other.emailSuggestionResult))) {
            return false;
        }
        return true;
    }

}
