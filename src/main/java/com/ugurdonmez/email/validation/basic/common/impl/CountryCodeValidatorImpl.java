package com.ugurdonmez.email.validation.basic.common.impl;

import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.data.CountryCodeStorage;

/**
 *
 * @author ugurdonmez
 */
public class CountryCodeValidatorImpl implements CountryCodeValidator {

    public boolean isCountryCodeCorrect(String countryCode) {
        return CountryCodeStorage.getInstance().isIncludeCountryDomain(countryCode);
    }
}
