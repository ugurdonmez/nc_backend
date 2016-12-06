package test;

import com.ugurdonmez.data.trie.Trie;
import com.ugurdonmez.email.validation.basic.data.CountryCodeStorage;

/**
 *
 * @author ugurdonmez
 */
public class NewClass {
    
    public static void main(String [] args) {
        
        CountryCodeStorage ins = CountryCodeStorage.getInstance();
        
        ins.isIncludeCountryDomain("tr");
        
    }
    
}
