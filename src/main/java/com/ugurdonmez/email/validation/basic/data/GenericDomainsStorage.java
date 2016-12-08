package com.ugurdonmez.email.validation.basic.data;

import com.ugurdonmez.data.trie.Trie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Singleton class to top level domain names in trie data structure
 * 
 * @author ugurdonmez
 */
public class GenericDomainsStorage {
    
    /**
     * Singleton GenericDomainsStorage instance
     */
    private static GenericDomainsStorage instance = null;
    
    /**
     * Trie to store top level domains
     */
    private Trie genericDomainTrie;

    /**
     * Private GenericDomainsStorage constructor
     */
    private GenericDomainsStorage() {
        
        // initialize Trie
        genericDomainTrie = new Trie();
        
        try {
            // scanner for resources/generic_domains.txt file
            Scanner scanner = new Scanner(GenericDomainsStorage.class.getClassLoader().getResourceAsStream("domain_files/generic_domains.txt"));
            
            // iterate each line
            while (scanner.hasNextLine()) {
                // add line to trie
                genericDomainTrie.addWord(scanner.nextLine());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Return GenericDomainsStorage instance
     * 
     * @return GenericDomainsStorage
     */
    public static GenericDomainsStorage getInstance() {
        if (instance == null) {
            instance = new GenericDomainsStorage();
        }
        return instance;
    }
    
    /**
     * Check that top level domain defined
     * 
     * @param domainName
     * @return boolean
     */
    public boolean isIncludeGenericDomain(String domainName) {
        return this.genericDomainTrie.isInclude(domainName);
    }
}
