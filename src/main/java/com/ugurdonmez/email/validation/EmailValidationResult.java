package com.ugurdonmez.email.validation;

/**
 * 
 * Store email validation results
 * 
 * @author ugurdonmez
 */
public class EmailValidationResult {

    private final boolean isSyntaxCorrect;
    private final boolean isDomainCorrect;
    private final boolean isTopLevelDomainCorrect;
    private final boolean isCountryCodeCorrect;

    public EmailValidationResult(boolean isSyntaxCorrect, boolean isDomainCorrect, boolean isTopLevelDomainCorrect, boolean isCountryCodeCorrect) {
        this.isSyntaxCorrect = isSyntaxCorrect;
        this.isDomainCorrect = isDomainCorrect;
        this.isTopLevelDomainCorrect = isTopLevelDomainCorrect;
        this.isCountryCodeCorrect = isCountryCodeCorrect;
    }

    public boolean isIsSyntaxCorrect() {
        return isSyntaxCorrect;
    }

    public boolean isIsDomainCorrect() {
        return isDomainCorrect;
    }

    public boolean isIsTopLevelDomainCorrect() {
        return isTopLevelDomainCorrect;
    }

    public boolean isIsCountryCodeCorrect() {
        return isCountryCodeCorrect;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.isSyntaxCorrect ? 1 : 0);
        hash = 19 * hash + (this.isDomainCorrect ? 1 : 0);
        hash = 19 * hash + (this.isTopLevelDomainCorrect ? 1 : 0);
        hash = 19 * hash + (this.isCountryCodeCorrect ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmailValidationResult other = (EmailValidationResult) obj;
        if (this.isSyntaxCorrect != other.isSyntaxCorrect) {
            return false;
        }
        if (this.isDomainCorrect != other.isDomainCorrect) {
            return false;
        }
        if (this.isTopLevelDomainCorrect != other.isTopLevelDomainCorrect) {
            return false;
        }
        if (this.isCountryCodeCorrect != other.isCountryCodeCorrect) {
            return false;
        }
        return true;
    }
}
