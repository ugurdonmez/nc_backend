package com.ugurdonmez.email.validation.basic.divide;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ugurdonmez
 */
public class DivideUtilTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testLocal1() {
        assertEquals("abc", DivideUtil.getLocalPartFromEmail("abc@abc.com"));
    }
    
    @Test
    public void testLocal2() {
        assertEquals("asd!#$%&'*+-/=?^_`{|}~", DivideUtil.getLocalPartFromEmail("asd!#$%&'*+-/=?^_`{|}~@abc.com"));
    }
    
    @Test
    public void testLocal3() {
        assertEquals("abcd.abcd", DivideUtil.getLocalPartFromEmail("abcd.abcd@gmail.com"));
    }
    
    @Test
    public void testLocal4() {
        assertEquals("abcd.abcd887", DivideUtil.getLocalPartFromEmail("abcd.abcd887@yahoo.co.uk"));
    }
    
    @Test
    public void testLocal5() {
        assertEquals("e12345", DivideUtil.getLocalPartFromEmail("e12345@metu.edu.tr"));
    }
    
    @Test
    public void testDomain1() {
        assertEquals("abc", DivideUtil.getDomainName("abc@abc.com"));
    }
    
    @Test
    public void testDomain2() {
        assertEquals("abc", DivideUtil.getDomainName("asd!#$%&'*+-/=?^_`{|}~@abc.com"));
    }
    
    @Test
    public void testDomain3() {
        assertEquals("gmail", DivideUtil.getDomainName("abcd.abcd@gmail.com"));
    }
    
    @Test
    public void testDomain4() {
        assertEquals("yahoo", DivideUtil.getDomainName("abcd.abcd887@yahoo.co.uk"));
    }
    
    @Test
    public void testDomain5() {
        assertEquals("metu", DivideUtil.getDomainName("e12345@metu.edu.tr"));
    }
    
    @Test
    public void testTopLevel1() {
        assertEquals("com", DivideUtil.getTopLevelDomain("abc@abc.com"));
    }
    
    @Test
    public void testTopLevel2() {
        assertEquals("com", DivideUtil.getTopLevelDomain("asd!#$%&'*+-/=?^_`{|}~@abc.com"));
    }
    
    @Test
    public void testTopLevel3() {
        assertEquals("com", DivideUtil.getTopLevelDomain("abcd.abcd@gmail.com"));
    }
    
    @Test
    public void testTopLevel4() {
        assertEquals("co", DivideUtil.getTopLevelDomain("abcd.abcd887@yahoo.co.uk"));
    }
    
    @Test
    public void testTopLevel5() {
        assertEquals("edu", DivideUtil.getTopLevelDomain("e12345@metu.edu.tr"));
    }
    
    @Test
    public void testCountry1() {
        assertEquals("", DivideUtil.getCountryCode("abc@abc.com"));
    }
    
    @Test
    public void testCountry2() {
        assertEquals("", DivideUtil.getCountryCode("asd!#$%&'*+-/=?^_`{|}~@abc.com"));
    }
    
    @Test
    public void testCountry3() {
        assertEquals("", DivideUtil.getCountryCode("abcd.abcd@gmail.com"));
    }
    
    @Test
    public void testCountry4() {
        assertEquals("uk", DivideUtil.getCountryCode("abcd.abcd887@yahoo.co.uk"));
    }
    
    @Test
    public void testCountry5() {
        assertEquals("tr", DivideUtil.getCountryCode("e12345@metu.edu.tr"));
    }
    
    // TODO: we are not support subdomains now
    @Ignore
    @Test
    public void testDomain6() {
        assertEquals("abcd.abc", DivideUtil.getDomainName("abcd.abcd@abcd.abc.com.tr"));
    }
    
    @Test
    public void testTopLevelDomain6() {
        assertEquals("com", DivideUtil.getTopLevelDomain("abcd.abcd@abcd.abc.com.tr"));
    }
    
    @Test
    public void testCountryCode6() {
        assertEquals("tr", DivideUtil.getCountryCode("abcd.abcd@abcd.abc.com.tr"));
    }
    
    @Test
    public void testDomain7() {
        assertEquals("unibz", DivideUtil.getDomainName("abcde@unibz.it"));
    }
    
    @Test
    public void testTopLevelDomain7() {
        assertEquals("", DivideUtil.getTopLevelDomain("abcde@unibz.it"));
    }
    
    @Test
    public void testCountryCode7() {
        assertEquals("it", DivideUtil.getCountryCode("abcde@unibz.it"));
    }
        
    @Test
    public void testDomain8() {
        assertEquals("gmail", DivideUtil.getDomainName("abcd@gmail.comm.tr"));
    }
    
    @Test
    public void testTopLevelDomain8() {
        assertEquals("comm", DivideUtil.getTopLevelDomain("abcd@gmail.comm.tr"));
    }
    
    @Test
    public void testCountryCode8() {
        assertEquals("tr", DivideUtil.getCountryCode("abcd@gmail.comm.tr"));
    }
    
    @Test
    public void testDomain9() {
        assertEquals("gmail", DivideUtil.getDomainName("abcd@gmail.com.trr"));
    }
    
    @Test
    public void testTopLevelDomain9() {
        assertEquals("com", DivideUtil.getTopLevelDomain("abcd@gmail.com.trr"));
    }
    
    @Test
    public void testCountryCode9() {
        assertEquals("trr", DivideUtil.getCountryCode("abcd@gmail.comm.trr"));
    }
    
    @Test
    public void testDomain10() {
        assertEquals("gmail", DivideUtil.getDomainName("abcd@gmail.comm.trr"));
    }
    
    @Test
    public void testTopLevelDomain10() {
        assertEquals("comm", DivideUtil.getTopLevelDomain("abcd@gmail.comm.trr"));
    }
    
    @Test
    public void testCountryCode10() {
        assertEquals("trr", DivideUtil.getCountryCode("abcd@gmail.commm.trr"));
    }
    
    @Test
    public void testDomain11() {
        assertEquals("gnail", DivideUtil.getDomainName("abcd@gnail.comm.trr"));
    }
    
    @Test
    public void testTopLevelDomain11() {
        assertEquals("comm", DivideUtil.getTopLevelDomain("abcd@gmail.comm.trr"));
    }
    
    @Test
    public void testCountryCode11() {
        assertEquals("trr", DivideUtil.getCountryCode("abcd@gmail.commm.trr"));
    }
    
    
}
