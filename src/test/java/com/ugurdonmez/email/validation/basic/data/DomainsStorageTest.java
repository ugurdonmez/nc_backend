package com.ugurdonmez.email.validation.basic.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class DomainsStorageTest {
    
    private DomainsStorage domainsStorage;
    
    public DomainsStorageTest() {
        domainsStorage = DomainsStorage.getInstance();
    }
    
    @Test
    public void test1() {
        assertTrue("should include", domainsStorage.isIncludeDomain("facebook"));
    }
    
    @Test
    public void test2() {
        assertTrue("should include", domainsStorage.isIncludeDomain("tcnj"));
    }
    
}
