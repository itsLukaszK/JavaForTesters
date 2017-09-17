package com.javafortesters.chap010.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Chapter010 {
    @Test
    public void useAForLoopInsteadOfAWhileLoop() {
        String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};
        List<String> days = Arrays.asList(someDays);
        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        assertEquals("Monday is at position 3", 3, count);

        int i;
        for (i = 0; !days.get(i).equals("Monday"); i++) {
        }
        assertEquals("Monday is at position 3", 3, i);
    }
}
