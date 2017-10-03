package com.javafortesters.chap014.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Chapter014JUnitExplored {
    @Test
    public void allOfTheAsserts() {
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

    @Test
    public void assertThatInsteadOfAllOfTheAsserts() {
        int number1 = 1;
        assertThat(number1, is(1));
        int number2 = 2;
        assertThat(number1, is(not(number2)));
        assertThat(number1, not(equalTo(number2)));
        int[] array1 = {1, 2};
        int[] array2 = {number1, number2};
        assertThat(array1, equalTo(array2));
        assertThat(number1, is(not(nullValue())));
        int number2minus1 = 2 - 1;
        assertThat(number2, not(equalTo(number1)));
        String number3 = null;
        assertThat(number3, is(nullValue()));
        assertThat(number1, equalTo(number2minus1));
        assertThat(number3, not(containsString("null")));
        String number4 = "four";
        assertThat(number4, containsString("ou"));
        assertThat(number4, endsWith("our"));
        assertThat(number4, startsWith("fou"));
    }
}
