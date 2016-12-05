package com.ugurdonmez.email.validation.basic.data;

import com.ugurdonmez.data.trie.Trie;
import java.io.File;
import java.io.FileNotFoundException;
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

    private static CountryCodeStorage instance = null;
    
    private Trie countryCodeTrie;

    private CountryCodeStorage() {
        
        countryCodeTrie = new Trie();
        
        try {
            Scanner scanner = new Scanner(new File("resources/country_domains.txt"));
            
            // add each line to trie
            while (scanner.hasNextLine()) {
                countryCodeTrie.addWord(scanner.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CountryCodeStorage getInstance() {
        if (instance == null) {
            instance = new CountryCodeStorage();
        }
        return instance;
    }
    
    public boolean isIncludeCountryDomain(String domainName) {
        return this.countryCodeTrie.isInclude(domainName);
    }
}
