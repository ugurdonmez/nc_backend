package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidator;
import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidatorTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class TopLevelDomainValidatorImplTest extends TopLevelDomainValidatorTest<TopLevelDomainValidatorImpl>{

    @Override
    protected TopLevelDomainValidatorImpl createInstance() {
        return new TopLevelDomainValidatorImpl();
    }
    
}
