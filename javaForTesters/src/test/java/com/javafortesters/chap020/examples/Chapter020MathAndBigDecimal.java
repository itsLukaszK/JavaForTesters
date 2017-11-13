package com.javafortesters.chap020.examples;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Chapter020MathAndBigDecimal {
    @Test
    public void convinceYourselfOfBigDecimalOrInt() {
        double doubleValue = 5 - 0.3 - 0.47 - 1.73;
        System.out.println(doubleValue);
        int intValue = (int) (5 - 0.3 - 0.47 - 1.73);
        System.out.println(intValue);
        BigDecimal bdValue = ((new BigDecimal("5").subtract(new BigDecimal("0.3"))).subtract(new BigDecimal("0.47"))).subtract(new BigDecimal("1.73"));
        System.out.println(bdValue);
    }

    @Test
    public void basicArithmeticWithBigDecimal() {
        BigDecimal aBigDecimal = BigDecimal.ZERO;
        assertEquals(BigDecimal.valueOf(5), ((aBigDecimal.add(BigDecimal.TEN)).multiply(new BigDecimal(2)).subtract(BigDecimal.TEN)).divide(new BigDecimal(2)));
    }

    @Test
    public void compareTENandONE() {
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        assertTrue(BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0);
        assertFalse(BigDecimal.TEN.equals(BigDecimal.ONE));
        assertTrue(!BigDecimal.TEN.equals(BigDecimal.ONE));
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0 || BigDecimal.TEN.equals(BigDecimal.ONE));
        assertTrue(BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0 || BigDecimal.TEN.equals(BigDecimal.ONE));
    }
}
