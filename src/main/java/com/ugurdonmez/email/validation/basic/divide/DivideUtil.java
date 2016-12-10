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
        
        if (email == null) {
            return null;
        }
        
        String [] splittedAddress = email.split("@");
        
        if (splittedAddress.length < 2) {
            return null;
        }
        
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(splittedAddress[1]);
        // get public part of domain (top level domain.country code)
        
        if (fullDomainName.parts().size() == 0) {
            return null;
        }
        
        // return only domain name without top level domain and country code
        return  fullDomainName.parts().get(0);
    }
    
    /**
     * get top level domain from email address
     * 
     * @param email
     * @return String
     */
    public static String getTopLevelDomain(String email) {
        
        if (email == null) {
            return null;
        }
        
        String [] splittedAddress = email.split("@");
        
        if (splittedAddress.length < 2) {
            return null;
        }
       
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(splittedAddress[1]);
        
        // we have unvalid public suffix
        if (!fullDomainName.hasPublicSuffix()) {
            if (fullDomainName.parts().size() == 1) {
                return null;
            }
            // TODO: now we assume that we dont have subdomain and country code is at the end
            return fullDomainName.parts().get(1);
        }
        
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
                // it is possible that we have non valid top level domain
                // gmail.comm.tr
                if (fullDomainName.parts().size() >= 3) {
                    return fullDomainName.parts().get(fullDomainName.parts().size()-2);
                }
                
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
        
        if (email == null) {
            return null;
        }
        
        String [] splittedAddress = email.split("@");
        
        if (splittedAddress.length < 2) {
            return null;
        }
       
        // get full domain name
        InternetDomainName fullDomainName = InternetDomainName.from(splittedAddress[1]);
        
        // we have unvalid public suffix
        if (!fullDomainName.hasPublicSuffix()) {
            // TODO: now we assume that we dont have subdomain and country code is at the end
            if (fullDomainName.parts().size() == 3) {
                return fullDomainName.parts().get(2);
            } else {
                // if we have only two part, one is domain and second is top level domain
                // TODO: not always true
                return "";
            }
        }
        
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
