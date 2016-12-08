package com.ugurdonmez.email.suggestion.basic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ugurdonmez.email.suggestion.IEmailSuggestionTest;

/**
 *
 * @author ugurdonmez
 */
public class EmailSuggestionBasicTest extends IEmailSuggestionTest<EmailSuggestionBasic>{

    @Override
    protected EmailSuggestionBasic createInstance() {
        Injector injector = Guice.createInjector(new EmailSuggestionBasicModule());
        return injector.getInstance(EmailSuggestionBasic.class);
    }

}
