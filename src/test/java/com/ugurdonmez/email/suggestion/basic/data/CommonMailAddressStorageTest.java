package com.ugurdonmez.email.suggestion.basic.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class CommonMailAddressStorageTest {
    
    CommonMailAddressStorage commonMailStorage;
    
    public CommonMailAddressStorageTest() {
        commonMailStorage = CommonMailAddressStorage.getInstance();
    }
    
    @Test
    public void test(){
        assertTrue(commonMailStorage.getAddresses().contains("gmail.com"));
    }
    
    @Test
    public void test1(){
        assertTrue(commonMailStorage.getAddresses().contains("terra.com.br"));
    }
    
    @Test
    public void test2(){
        assertTrue(commonMailStorage.getAddresses().contains("btinternet.com"));
    }
    
    @Test
    public void test3(){
        assertTrue(commonMailStorage.getAddresses().contains("mail.ru"));
    }
    
    @Test
    public void test4(){
        assertTrue(commonMailStorage.getAddresses().contains("yahoo.co.uk"));
    }
    
}
