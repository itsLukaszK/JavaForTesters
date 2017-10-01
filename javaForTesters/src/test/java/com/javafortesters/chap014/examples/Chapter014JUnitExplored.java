package com.javafortesters.chap014.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class Chapter014JUnitExplored {
    @Test
    public void AllOfTheAsserts() {
        int number1 = 1;
        assertEquals(1, number1);
        int number2 = 2;
        assertFalse(number1 > number2);
        assertTrue(number1 < number2);
        int[] array1 = {1, 2};
        int[] array2 = {number1, number2};
        assertArrayEquals(array1, array2);
        assertNotNull(number1);
        int number2minus1 = 2 - 1;
        assertNotSame(number2, number1);
        String number3 = null;
        assertNull(number3);
        assertSame(number1, number2minus1);
    }
}
