package com.ugurdonmez.email.validation.basic;

import com.google.inject.Inject;
import com.ugurdonmez.email.validation.EmailValidationResult;
import com.ugurdonmez.email.validation.IEmailValidator;
import com.ugurdonmez.email.validation.basic.common.CountryCodeValidator;
import com.ugurdonmez.email.validation.basic.common.DomainValidator;
import com.ugurdonmez.email.validation.basic.common.SyntaxValidator;
import com.ugurdonmez.email.validation.basic.common.TopLevelDomainValidator;
import com.ugurdonmez.email.validation.basic.divide.DivideUtil;

/**
 * Validate email address by divide it to its domains and check each them
 * 
 * @author ugurdonmez
 */
public class EmailValidatorBasic implements IEmailValidator {
    
    private final CountryCodeValidator countryCodeValidator;
    private final DomainValidator domainValidator;
    private final SyntaxValidator syntaxValidator;
    private final TopLevelDomainValidator topLevelDomainValidator;
    
    @Inject
    public EmailValidatorBasic(CountryCodeValidator countryCodeValidator, DomainValidator domainValidator, SyntaxValidator syntaxValidator, TopLevelDomainValidator topLevelDomainValidator) {
        this.countryCodeValidator = countryCodeValidator;
        this.domainValidator = domainValidator;
        this.syntaxValidator = syntaxValidator;
        this.topLevelDomainValidator = topLevelDomainValidator;
    }
    
    public EmailValidationResult isValidEmail(String email) {
        
        boolean syntaxValidation = syntaxValidator.isSyntaxCorrect(email);
        boolean domainValidation = domainValidator.isDomainCorrect(DivideUtil.getDomainName(email));
        boolean topLevelDomainValidation = topLevelDomainValidator.isTopLevelDomainCorrect(DivideUtil.getTopLevelDomain(email));
        boolean countryCodeValidation = countryCodeValidator.isCountryCodeCorrect(DivideUtil.getCountryCode(email));
        
        return new EmailValidationResult(syntaxValidation, domainValidation, topLevelDomainValidation, countryCodeValidation);
    }
}
