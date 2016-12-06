package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.data.CountryCodeStorage;

/**
 * Class to validate county codes by using trie structure populated by resource/country_domains.txt
 * 
 * @author ugurdonmez
 */
public class CountryCodeValidatorImpl implements CountryCodeValidator {

    public boolean isCountryCodeCorrect(String countryCode) {
        
        // empty country code is valid
        if (countryCode.equals("")) {
            return true;
        }
        
        return CountryCodeStorage.getInstance().isIncludeCountryDomain(countryCode);
    }
}
