package com.ugurdonmez.email.validation.basic.data;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class GenericDomainsStorageTest {
    
    GenericDomainsStorage genericDomainsStorage;
    
    public GenericDomainsStorageTest() {
        genericDomainsStorage = GenericDomainsStorage.getInstance();
    }
    
    @Test
    public void test1() {
        assertTrue("should include", genericDomainsStorage.isIncludeGenericDomain("aaa"));
    }
    
    @Test
    public void test2() {
        assertTrue("should include", genericDomainsStorage.isIncludeGenericDomain("accountant"));
    }
    
    @Test
    public void test3() {
        assertTrue("should include", genericDomainsStorage.isIncludeGenericDomain("youtube"));
    }
    
    @Test
    public void test4() {
        assertFalse("should not include", genericDomainsStorage.isIncludeGenericDomain("xxxxxxxxxxx"));
    }
    
    @Test
    public void test5() {
        assertFalse("should not include", genericDomainsStorage.isIncludeGenericDomain("ccccccccc"));
    }
    
    @Test
    public void test6() {
        assertFalse("should not include", genericDomainsStorage.isIncludeGenericDomain("aaaa"));
    }
}
