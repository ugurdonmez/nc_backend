package com.ugurdonmez.email.suggestion.stringdistance;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * 
 * @author ugurdonmez
 */
public abstract class StringDistanceCalculatorTest<T extends StringDistanceCalculator> {
    
    T distanceCalculator;
    
    protected abstract T createInstance();
    
    @Before
    public void setUp() {
        distanceCalculator = createInstance();
    }
    
    @Test
    public void distanceBetweenNullFirstStringAndSecondStringIsLengthOfSecondString() {
        assertEquals(6D, distanceCalculator.getDistance(null, "abcdef"), 0D);
    }

    @Test
    public void distanceBetweenEmptyFirstStringAndSecondStringIsLengthOfSecondString() {
        assertEquals(6D, distanceCalculator.getDistance("", "abcdef"), 0D);
    }

    @Test
    public void distanceBetweenFirstStringAndNullSecondStringIsLengthOfFirstString() {
        assertEquals(5D, distanceCalculator.getDistance("abcde", null), 0D);
    }

    @Test
    public void distanceBetweenFirstStringAndEmptySecondStringIsLengthOfFirstString() {
        assertEquals(5D, distanceCalculator.getDistance("abcde", ""), 0D);
    }

    @Test
    public void distanceBetweenIdenticalStringsIsZero() {
        assertEquals(0D, distanceCalculator.getDistance("abcdef", "abcdef"), 0D);
    }

    @Test
    public void oneCharacterDifferenceBetweenStringsGivesDistanceOfOne() {
        assertEquals(1D, distanceCalculator.getDistance("abcdef", "abcdeZ"), 0D);
    }

    @Test
    public void twoCharacterDifferenceBetweenStringsIs2() {
        assertEquals(2D, distanceCalculator.getDistance("abcdef", "ZbcdeZ"), 0D);
    }

    @Test
    public void differenceFurtherThanMaximumOffsetBetweenStringsIsCountedAsDistance() {
        assertEquals(0D, distanceCalculator.getDistance("abcdef", "abcdefg"), 0.5f);
    }

    @Test
    public void differenceCloserThanMaximumOffsetBetweenStringsGivesDistanceOfOne() {
        assertEquals(1D, distanceCalculator.getDistance("abc", "abZ"), 0D);
    }

    @Test
    public void additionalCharacterWithinOffsetRangeIsCountedAsDistance() {
        assertEquals(0D, distanceCalculator.getDistance("abc", "abcd"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest() {
        assertEquals(1D, distanceCalculator.getDistance("gmail.com", "gnail.com"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest1() {
        assertEquals(1D, distanceCalculator.getDistance("yahoo.co.uk", "yahoo.com.uk"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest2() {
        assertEquals(1D, distanceCalculator.getDistance("gmail.com", "gmai.com"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest3() {
        assertEquals(1D, distanceCalculator.getDistance("gmail.com", "gmail.comm"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest4() {
        assertEquals(2D, distanceCalculator.getDistance("gmail.com", "gmai.comm"), 0.5f);
    }
    
    @Ignore
    @Test
    public void mailDistanceTest5() {
        assertEquals(2D, distanceCalculator.getDistance("gmail.com", "gmail.c"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest6() {
        assertEquals(2D, distanceCalculator.getDistance("gmail.com", "gma.com"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest7() {
        assertEquals(2D, distanceCalculator.getDistance("gmail.com", "ail.com"), 0.5f);
    }
    
    @Ignore
    @Test
    public void mailDistanceTest8() {
        assertEquals(3D, distanceCalculator.getDistance("gmail.com", "gnaol.con"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest9() {
        assertEquals(3D, distanceCalculator.getDistance("gmail.com", "gmail.vin"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest10() {
        assertEquals(3D, distanceCalculator.getDistance("gmail.com", "gmaicon"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest11() {
        assertEquals(3D, distanceCalculator.getDistance("gmail.com", "gmaicon"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest12() {
        float a = distanceCalculator.getDistance("yahoo.co.u", "yahoo.co.uk");
        assertEquals(1D, distanceCalculator.getDistance("yahoo.co.u", "yahoo.co.uk"), 0.5f);
    }
    
    @Test
    public void mailDistanceTest13() {
        assertEquals(1D, distanceCalculator.getDistance("yahoo.co.u", "yahoo.com"), 0.5f);
    }
}
