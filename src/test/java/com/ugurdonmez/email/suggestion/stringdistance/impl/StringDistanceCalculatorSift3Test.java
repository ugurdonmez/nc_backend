package com.ugurdonmez.email.suggestion.stringdistance.impl;

import com.ugurdonmez.email.suggestion.stringdistance.StringDistanceCalculator;
import com.ugurdonmez.email.suggestion.stringdistance.StringDistanceCalculatorTest;

/**
 *
 * @author ugurdonmez
 */
public class StringDistanceCalculatorSift3Test extends StringDistanceCalculatorTest<StringDistanceCalculator>{

    @Override
    protected StringDistanceCalculator createInstance() {
        return new StringDistanceCalculatorSift3();
    }
    
}
