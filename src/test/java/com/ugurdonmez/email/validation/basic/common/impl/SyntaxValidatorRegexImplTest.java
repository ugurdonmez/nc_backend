package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.impl.SyntaxValidatorRegexImpl;
import com.ugurdonmez.email.validation.basic.common.SyntaxValidatorTest;
import org.junit.Ignore;

/**
 *
 * @author ugurdonmez
 */
@Ignore
public class SyntaxValidatorRegexImplTest extends SyntaxValidatorTest<SyntaxValidatorRegexImpl>{

    @Override
    protected SyntaxValidatorRegexImpl createInstance() {
        return new SyntaxValidatorRegexImpl();
    }
}
