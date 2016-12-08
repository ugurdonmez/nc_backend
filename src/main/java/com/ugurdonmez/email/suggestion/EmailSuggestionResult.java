package com.ugurdonmez.email.suggestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Store suggested email addresses and distance
 * 
 * @author ugurdonmez
 */
public class EmailSuggestionResult {
    
    // suggested email address
    private List<String> suggestions;
    // distance between suggested mail and input mail
    private int distance;
    
    /**
     * Default constructor
     */
    public EmailSuggestionResult() {
        suggestions = new ArrayList<String>();
    }
    
    /**
     * Construct with distance
     * 
     * @param distance 
     */
    public EmailSuggestionResult(int distance) {
        this();
        this.distance = distance;
    }
    
    /**
     * Construct with distance and suggested list
     * 
     * @param suggestions
     * @param distance 
     */
    public EmailSuggestionResult(List<String> suggestions, int distance) {
        this.suggestions = suggestions;
        this.distance = distance;
    }
    
    /**
     * Add new suggested mail to result list
     * 
     * @param email String
     */
    public void addToSuggestions(String email) {
        suggestions.add(email);
    }

    /**
     * Get suggested list
     * 
     * @return 
     */
    public List<String> getSuggestions() {
        return suggestions;
    }

    /**
     * Get distance
     * 
     * @return int
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Set distance
     * 
     * @param distance int
     */
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
