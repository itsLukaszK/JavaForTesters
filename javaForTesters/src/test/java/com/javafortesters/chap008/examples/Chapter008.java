package com.javafortesters.chap008.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Chapter008 {
    // Ex1
    @Test
    public void cats() {

        assertEquals("2 == cats", "cats", catOrCats(2));
    }

    private String catOrCats(int numberOfCats) {
        return numberOfCats == 1 ? "cat" : "cats";
    }


    // Ex2
    boolean truthy = true;

    @Test
    public void assertTrueIfTrue() {
        if (truthy == true) assertTrue(truthy);
    }

    @Test
    public void assertTrueAndFalse() {
        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        }
    }


    // Ex3
    @Test
    public void assertTrueElseFalse() {
        if (truthy) assertTrue(truthy);
        else assertFalse(truthy);

        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        } else assertFalse(truthy);
    }
}
