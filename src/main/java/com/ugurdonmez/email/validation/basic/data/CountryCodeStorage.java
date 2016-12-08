package com.ugurdonmez.email.validation.basic.data;

import com.ugurdonmez.data.trie.Trie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Singleton class to store country codes in trie data structure
 *
 * @author ugurdonmez
 */
public class CountryCodeStorage {
    
    /**
     * Singleton CounrtyCodeStorage instance
     */
    private static CountryCodeStorage instance = null;
    
    /**
     * Trie to store country code
     */
    private Trie countryCodeTrie;

    /**
     * Private CountryCodeStorege constructor
     */
    private CountryCodeStorage() {
        
        // initialize Trie
        countryCodeTrie = new Trie();
        
        try {
            // scanner for resources/country_domains.txt file
            Scanner scanner = new Scanner(CountryCodeStorage.class.getClassLoader().getResourceAsStream("domain_files/country_domains.txt"));         
            // iterate each line
            while (scanner.hasNextLine()) {
                // add line to trie
                countryCodeTrie.addWord(scanner.nextLine());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Return CountryCodeStorage instance
     * 
     * @return CountryCodeStorage
     */
    public static CountryCodeStorage getInstance() {
        if (instance == null) {
            instance = new CountryCodeStorage();
        }
        return instance;
    }
    
    /**
     * Check that country domains defined
     * 
     * @param domainName
     * @return boolean
     */
    public boolean isIncludeCountryDomain(String domainName) {
        return this.countryCodeTrie.isInclude(domainName);
    }
}
