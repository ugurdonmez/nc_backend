package com.ugurdonmez.email.suggestion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ugurdonmez
 */
public class EmailSuggestionResult {
    
    private List<String> suggestions;
    private int distance;
    
    public EmailSuggestionResult() {
        suggestions = new ArrayList<String>();
    }
    
    public EmailSuggestionResult(int distance) {
        this();
        this.distance = distance;
    }
    
    public EmailSuggestionResult(List<String> suggestions, int distance) {
        this.suggestions = suggestions;
        this.distance = distance;
    }
    
    public void addToSuggestions(String email) {
        suggestions.add(email);
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.suggestions != null ? this.suggestions.hashCode() : 0);
        hash = 59 * hash + Float.floatToIntBits(this.distance);
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
        final EmailSuggestionResult other = (EmailSuggestionResult) obj;
        if (Float.floatToIntBits(this.distance) != Float.floatToIntBits(other.distance)) {
            return false;
        }
        if (this.suggestions != other.suggestions && (this.suggestions == null || !this.suggestions.equals(other.suggestions))) {
            return false;
        }
        return true;
    }
}
