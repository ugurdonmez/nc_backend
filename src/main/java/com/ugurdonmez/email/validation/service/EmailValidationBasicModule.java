/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
