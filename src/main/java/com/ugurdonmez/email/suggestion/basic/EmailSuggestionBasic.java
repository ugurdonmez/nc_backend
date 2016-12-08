package com.ugurdonmez.email.suggestion.basic;

import com.google.inject.Inject;
import com.ugurdonmez.email.suggestion.EmailSuggestionResult;
import com.ugurdonmez.email.suggestion.IEmailSuggestion;
import com.ugurdonmez.email.suggestion.basic.data.CommonMailAddressStorage;
import com.ugurdonmez.email.suggestion.stringdistance.StringDistanceCalculator;
import com.ugurdonmez.email.validation.basic.divide.DivideUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ugurdonmez
 */
public class EmailSuggestionBasic implements IEmailSuggestion {
    
    private final StringDistanceCalculator stringDistanceCalculator;

    @Inject
    public EmailSuggestionBasic(StringDistanceCalculator stringDistanceCalculator) {
        this.stringDistanceCalculator = stringDistanceCalculator;
    }
    
    public EmailSuggestionResult getEmailSuggestions(String email) {
        
        if (email == null || email.equals("")) {
            return null;
        }
        
        String domain = getDomain(email);
        String localPart = DivideUtil.getLocalPartFromEmail(email);
        
        int currentDistance = 100;
        List<String> list = new ArrayList<String>();
        
        Set<String> commonAdresses = CommonMailAddressStorage.getInstance().getAddresses();
        
        for (String commonDomain : commonAdresses) {
            int distance = (int) Math.ceil(stringDistanceCalculator.getDistance(domain, commonDomain));
            
            if (distance == 0) {
                return new EmailSuggestionResult(0);
            }
            
            if (distance == currentDistance) {
                list.add(commonDomain);
            } else if (distance < currentDistance) {
                list.clear();
                currentDistance = distance;
                list.add(commonDomain);
            }
        }
        
        EmailSuggestionResult result = new EmailSuggestionResult(currentDistance);
        
        for (String suggestedDomain : list) {
            result.addToSuggestions(localPart + "@" + suggestedDomain);
        }
        
        return result;
    }
    
    /**
     * return domain part of email
     * 
     * email must have domain part.
     * 
     * @param email
     * @return String
     */
    private String getDomain(String email) {
        return email.split("@")[1];
    }
    
}
