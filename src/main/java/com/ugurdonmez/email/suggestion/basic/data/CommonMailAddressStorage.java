package com.ugurdonmez.email.suggestion.basic.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton class to store common mail addresses codes in set data structure 
 * 
 * @author ugurdonmez
 */
public class CommonMailAddressStorage {
    /**
     * Singleton CommonMailAddressStorage instance
     */
    private static CommonMailAddressStorage instance = null;
    
    /**
     * Set to store country code
     */
    private Set<String> commonMailAdressesSet;

    /**
     * Private CommonMailAddressStorage constructor
     */
    private CommonMailAddressStorage() {
        
        // construct a set
        commonMailAdressesSet = new HashSet<String>();
        
        try {
            Scanner scanner = new Scanner(new File("resources/common_mail_domains.txt"));
            
            // iterate throught each line
            while(scanner.hasNextLine()) {
                commonMailAdressesSet.add(scanner.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommonMailAddressStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Return CommonMailAddressStorage instance
     * 
     * @return CommonMailAddressStorage
     */
    public static CommonMailAddressStorage getInstance() {
        if (instance == null) {
            instance = new CommonMailAddressStorage();
        }
        return instance;
    }
    
    /**
     * return all addresses
     * 
     * @return Set<String>
     */
    public Set<String> getAddresses(){
        return this.commonMailAdressesSet;
    }
}
