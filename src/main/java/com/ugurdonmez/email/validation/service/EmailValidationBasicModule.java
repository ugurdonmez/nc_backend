package com.ugurdonmez.email.validation.service;

import com.google.inject.AbstractModule;
import com.ugurdonmez.email.validation.basic.EmailValidatorBasic;
import com.ugurdonmez.email.validation.IEmailValidator;

/**
 *
 * @author ugurdonmez
 */
public class EmailValidationBasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IEmailValidator.class).to(EmailValidatorBasic.class);
    }

}
