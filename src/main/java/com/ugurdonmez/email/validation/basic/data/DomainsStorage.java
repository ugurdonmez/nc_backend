package com.ugurdonmez.email.validation.basic.data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ugurdonmez.data.trie.Trie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugurdonmez
 */
public class DomainsStorage {
    
    /**
     * Singleton CounrtyCodeStorage instance
     */
    private static DomainsStorage instance = null;
    
    /**
     * Trie to store country code
     */
    private Trie domainsTrie;

    /**
     * Private CountryCodeStorege constructor
     */
    private DomainsStorage() {
        
        /**
         * Add Well Known Domains
         */
        
        // initialize Trie
        domainsTrie = new Trie();
        
        try {
            // scanner for resources/country_domains.txt file
            Scanner scanner = new Scanner(new File("resources/generic_domains.txt"));
            
            // iterate each line
            while (scanner.hasNextLine()) {
                // add line to trie
                domainsTrie.addWord(scanner.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /**
         * Add University Domains
         */
        
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("resources/world_universities_and_domains.json"));
            UniversityDomainPOJO[] array = gson.fromJson(reader.toString(), UniversityDomainPOJO[].class);
            
            for (UniversityDomainPOJO pj : array) {
                String [] splitted = pj.getDomain().split("\\.");
                domainsTrie.addWord(splitted[0]);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DomainsStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Return CountryCodeStorage instance
     * 
     * @return CountryCodeStorage
     */
    public static DomainsStorage getInstance() {
        if (instance == null) {
            instance = new DomainsStorage();
        }
        return instance;
    }
    
    /**
     * Check that country domains defined
     * 
     * @param domainName
     * @return boolean
     */
    public boolean isIncludeDomain(String domainName) {
        return this.domainsTrie.isInclude(domainName);
    }
    
}
