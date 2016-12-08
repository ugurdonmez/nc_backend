package com.ugurdonmez.email.suggestion.basic;

import com.google.inject.AbstractModule;
import com.ugurdonmez.email.suggestion.IEmailSuggestion;
import com.ugurdonmez.email.suggestion.stringdistance.StringDistanceCalculator;
import com.ugurdonmez.email.suggestion.stringdistance.impl.StringDistanceCalculatorSift3;

/**
 * Create basic email suggestion module
 * 
 * @author ugurdonmez
 */
public class EmailSuggestionBasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StringDistanceCalculator.class).to(StringDistanceCalculatorSift3.class);
        bind(IEmailSuggestion.class).to(EmailSuggestionBasic.class);
    }
    
}
