package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.impl.SyntaxValidatorRegexImpl;
import com.ugurdonmez.email.validation.basic.common.SyntaxValidatorTest;

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