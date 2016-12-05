package com.ugurdonmez.email.validation.basic.data;

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
public class CountryCodeStorageTest {
    
    CountryCodeStorage countryCodeStorage;
    
    public CountryCodeStorageTest() {
        countryCodeStorage = CountryCodeStorage.getInstance();
    }

    @Test
    public void testIsInclude1() {
        assertTrue("should include country code tr", countryCodeStorage.isIncludeCountryDomain("tr"));
    }
    
    @Test
    public void testIsInclude2() {
        assertFalse("should not include country code abcde", countryCodeStorage.isIncludeCountryDomain("abcde"));
    }
    
    @Test
    public void testIsInclude3() {
        assertTrue("should include country code it", countryCodeStorage.isIncludeCountryDomain("it"));
    }
    
    @Test
    public void testIsInclude4() {
        assertTrue("should include country code eu", countryCodeStorage.isIncludeCountryDomain("eu"));
    }
    
    @Test
    public void testIsInclude5() {
        assertTrue("should include country code tk", countryCodeStorage.isIncludeCountryDomain("tk"));
    }
    
    @Test
    public void testIsInclude6() {
        assertTrue("should include country code ไทย", countryCodeStorage.isIncludeCountryDomain("ไทย"));
    }
    
    @Test
    public void testIsInclude7() {
        assertTrue("should include country code zw", countryCodeStorage.isIncludeCountryDomain("zw"));
    }
    
}
