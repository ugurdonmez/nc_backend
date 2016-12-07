package com.ugurdonmez.email.validation.basic;

import com.google.inject.AbstractModule;
import com.ugurdonmez.email.validation.IEmailValidator;
import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.common.DomainValidator;
import com.ugurdonmez.email.validation.basic.common.SyntaxValidator;
import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidator;
import com.ugurdonmez.email.validation.basic.common.impl.CountryCodeValidatorImpl;
import com.ugurdonmez.email.validation.basic.common.impl.DomainValidatorImpl;
import com.ugurdonmez.email.validation.basic.common.impl.SyntaxValidatorApacheCommonImpl;
import com.ugurdonmez.email.validation.basic.common.impl.TopLevelDomainValidatorImpl;

/**
 * Configure EmailValidatorBasic class with basic validator implementation
 * 
 * @author ugurdonmez
 */
public class EmailValidatorBasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SyntaxValidator.class).to(SyntaxValidatorApacheCommonImpl.class);
        bind(DomainValidator.class).to(DomainValidatorImpl.class);
        bind(TopLevelDomainValidator.class).to(TopLevelDomainValidatorImpl.class);
        bind(CountryCodeValidator.class).to(CountryCodeValidatorImpl.class);
        bind(IEmailValidator.class).to(EmailValidatorBasic.class);
    }
    
}
