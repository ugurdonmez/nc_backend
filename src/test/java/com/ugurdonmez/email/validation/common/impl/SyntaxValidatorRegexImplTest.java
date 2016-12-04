/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.email.validation.common.impl;

import com.ugurdonmez.email.validation.common.SyntaxValidatorTest;

/**
 *
 * @author ugurdonmez
 */
public class SyntaxValidatorRegexImplTest extends SyntaxValidatorTest<SyntaxValidatorRegexImpl>{

    @Override
    protected SyntaxValidatorRegexImpl createInstance() {
        return new SyntaxValidatorRegexImpl();
    }
}
