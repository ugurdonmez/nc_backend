package com.ugurdonmez.email.validation.basic.data;

import com.ugurdonmez.data.trie.Trie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugurdonmez
 */
public class GenericDomainsStorage {
    private static GenericDomainsStorage instance = null;
    
    private Trie genericDomainTrie;

    private GenericDomainsStorage() {
        
        genericDomainTrie = new Trie();
        
        try {
            Scanner scanner = new Scanner(new File("resources/generic_domains.txt"));
            
            // add each line to trie
            while (scanner.hasNextLine()) {
                genericDomainTrie.addWord(scanner.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static GenericDomainsStorage getInstance() {
        if (instance == null) {
            instance = new GenericDomainsStorage();
        }
        return instance;
    }
    
    public boolean isIncludeGenericDomain(String domainName) {
        return this.genericDomainTrie.isInclude(domainName);
    }
}
