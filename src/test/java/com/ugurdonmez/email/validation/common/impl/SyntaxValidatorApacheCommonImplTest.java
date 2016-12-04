package com.ugurdonmez.email.validation.common.impl;

import com.ugurdonmez.email.validation.common.SyntaxValidatorTest;


/**
 *
 * @author ugurdonmez
 */
public class SyntaxValidatorApacheCommonImplTest extends SyntaxValidatorTest<SyntaxValidatorApacheCommonImpl>{

    @Override
    protected SyntaxValidatorApacheCommonImpl createInstance() {
        return new SyntaxValidatorApacheCommonImpl();
    }
}
