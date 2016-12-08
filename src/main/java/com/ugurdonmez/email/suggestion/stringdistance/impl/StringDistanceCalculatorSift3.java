package com.ugurdonmez.email.suggestion.stringdistance.impl;

import com.ugurdonmez.email.suggestion.stringdistance.StringDistanceCalculator;

/**
 * Calculate string distance by using Sif3 algorithm
 * 
 * ref: https://siderite.blogspot.com/2007/04/super-fast-and-accurate-string-distance.html#at936057205
 * 
 * @author ugurdonmez
 */
public class StringDistanceCalculatorSift3 implements StringDistanceCalculator {

    public float getDistance(String firstString, String secondString) {
        
        if (isNullOrEmpty(firstString)) {
            return isNullOrEmpty(secondString) ? 0 : secondString.length();
        }
        
        if (isNullOrEmpty(secondString)) {
            return firstString.length();
        }

        int c = 0;
        int offset1 = 0;
        int offset2 = 0;
        int lcs = 0;
        
        int maxOffset = 5;

        while (c + offset1 < firstString.length() && (c + offset2 < secondString.length())) {
            if (firstString.charAt(c + offset1) == secondString.charAt(c + offset2)) {
                lcs++;
            } else {
                offset1 = 0;
                offset2 = 0;
                for (int i = 0; i < maxOffset; i++) {
                    if ((c + i < firstString.length())
                            && (firstString.charAt(c + i) == secondString.charAt(c))) {
                        offset1 = i;
                        break;
                    }
                    if ((c + i < secondString.length())
                            && (firstString.charAt(c) == secondString.charAt(c + i))) {
                        offset2 = i;
                        break;
                    }
                }
            }
            c++;
        }
        return (firstString.length() + secondString.length()) / 2.0f - lcs;
    }

    private boolean isNullOrEmpty(String candidate) {
        return candidate == null || candidate.length() == 0;
    }
}
