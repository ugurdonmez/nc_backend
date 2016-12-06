package com.ugurdonmez.email.validation.basic.divide;

import com.google.common.net.InternetDomainName;
import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.common.impl.CountryCodeValidatorImpl;

/**
 * 
 * DivideUtil divides email address to local-part, domain, top level domain and country code
 * 
 * Mail address formats
 * 
 * local-part@domain.tld.cc
 * local-part@domain1.domain2.tld.cc
 * local-part@domain.cc
 * local-part@domain.tld
 * 
 * Google guava InternetDomainName class was used.
 * ref: https://github.com/google/guava/wiki/InternetDomainNameExplained
 * 
 * @author ugurdonmez
 */
public class DivideUtil {
    
    /**
     * get local part from email address
     * 
     * @param email
     * @return String
     */
    public static String getLocalPartFromEmail(String email) {
        return email.split("@")[0];
    }
    
    /**
     * get domain part from email address
     * 
     * @param email
     * @return String
     */
    public static String getDomainName(String email) {
        
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(email.split("@")[1]);
        // get public part of domain (top level domain.country code)
        InternetDomainName publicDomainName = fullDomainName.publicSuffix();
        
        String fd = fullDomainName.toString();
        String pdn = publicDomainName.toString();
        
        // return only domain name without top level domain and country code
        return  fullDomainName.toString().substring(0, fd.length() - pdn.length() - 1);
    }
    
    /**
     * get top level domain from email address
     * 
     * @param email
     * @return String
     */
    public static String getTopLevelDomain(String email) {
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(email.split("@")[1]);
        // get public part of domain (top level domain.country code)
        InternetDomainName publicDomainName = fullDomainName.publicSuffix();
        
        // there is no any public domain name
        if (publicDomainName.parts().size() == 0) {
            return "";
        }
        // if size is 1, we have one top level domain
        else if (publicDomainName.parts().size() == 1) {
            // check that pdn is country code or top level domain name
            CountryCodeValidator countryCodeValidator = new CountryCodeValidatorImpl();
            
            // first part is country code, so there is no top level domain
            if (countryCodeValidator.isCountryCodeCorrect(publicDomainName.parts().get(0))) {
                return "";
            } else {
                return publicDomainName.parts().get(0);
            }
        } 
        // 
        else {
            return publicDomainName.parts().get(0);
        }
    }
    
    /**
     * get country code from email address
     * 
     * @param email
     * @return String
     */
    public static String getCountryCode(String email) {
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(email.split("@")[1]);
        // get public part of domain (top level domain.country code)
        InternetDomainName publicDomainName = fullDomainName.publicSuffix();
        
        // there is no any public domain name
        if (publicDomainName.parts().size() == 0) {
            return "";
        }
        // if size is 1, we have one top level domain
        else if (publicDomainName.parts().size() == 1) {
            // check that pdn is country code or top level domain name
            CountryCodeValidator countryCodeValidator = new CountryCodeValidatorImpl();
            
            // we found it in our country code trie
            if (countryCodeValidator.isCountryCodeCorrect(publicDomainName.parts().get(0))) {
                return publicDomainName.parts().get(0);
            } else {
                return "";
            }
        } 
        // 
        else {
            return publicDomainName.parts().get(1);
        }
    }
}
