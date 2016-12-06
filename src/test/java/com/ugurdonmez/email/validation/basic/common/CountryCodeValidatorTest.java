package com.ugurdonmez.email.validation.basic.common;

import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public abstract class CountryCodeValidatorTest <T extends CountryCodeValidator>{
    
    T countryCodeValitor;
    
    protected abstract T createInstance();
    
    @Before
    public void setUp() {
        countryCodeValitor = createInstance();
    }
    
    @Test
    public void testIsInclude1() {
        assertTrue("should include country code tr", countryCodeValitor.isCountryCodeCorrect("tr"));
    }
    
    @Test
    public void testIsInclude2() {
        assertFalse("should not include country code abcde", countryCodeValitor.isCountryCodeCorrect("abcde"));
    }
    
    @Test
    public void testIsInclude3() {
        assertTrue("should include country code it", countryCodeValitor.isCountryCodeCorrect("it"));
    }
    
    @Test
    public void testIsInclude4() {
        assertTrue("should include country code eu", countryCodeValitor.isCountryCodeCorrect("eu"));
    }
    
    @Test
    public void testIsInclude5() {
        assertTrue("should include country code tk", countryCodeValitor.isCountryCodeCorrect("tk"));
    }
    
    @Test
    public void testIsInclude6() {
        assertTrue("should include country code ไทย", countryCodeValitor.isCountryCodeCorrect("ไทย"));
    }
    
    @Test
    public void testIsInclude7() {
        assertTrue("should include country code zw", countryCodeValitor.isCountryCodeCorrect("zw"));
    }
}
