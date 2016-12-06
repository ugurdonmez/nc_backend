package com.ugurdonmez.email.validation.basic.divide;

import com.google.common.net.InternetDomainName;
import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.common.impl.CountryCodeValidatorImpl;

/**
 *
 * @author ugurdonmez
 */
public class DivideUtil {
    
    public static String getLocalPartFromEmail(String email) {
        return email.split("@")[0];
    }
    
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
