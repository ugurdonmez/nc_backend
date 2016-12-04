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
