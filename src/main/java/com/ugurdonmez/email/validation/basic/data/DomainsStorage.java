package com.ugurdonmez.email.validation.basic.data;

import com.ugurdonmez.email.validation.basic.data.pojo.UniversityDomainPOJO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ugurdonmez.data.trie.Trie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Singleton class to common email provider domains and university domains in
 * trie data structure
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
            Scanner scanner = new Scanner(DomainsStorage.class.getClassLoader().getResourceAsStream("domain_files/domains.txt"));

            // iterate each line
            while (scanner.hasNextLine()) {
                // add line to trie
                domainsTrie.addWord(scanner.nextLine());
            }

        } catch (Exception ex) {
            Logger.getLogger(CountryCodeStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * Add University Domains
         */
        try {
            
            BufferedReader reader = null;
            StringBuffer buffer = new StringBuffer();
            URL url = DomainsStorage.class.getClassLoader().getResource("domain_files/world_universities_and_domains.json");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            Gson gson = new Gson();

            UniversityDomainPOJO[] array = gson.fromJson(buffer.toString(), UniversityDomainPOJO[].class);

            for (UniversityDomainPOJO pj : array) {
                // remove top level domain and country code
                String[] splitted = pj.getDomain().split("\\.");
                domainsTrie.addWord(splitted[0]);
            }

        } catch (Exception ex) {
            Logger.getLogger(DomainsStorage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // TODO: close reader
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
