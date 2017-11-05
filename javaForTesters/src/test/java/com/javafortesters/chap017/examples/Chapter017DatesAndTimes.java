package com.javafortesters.chap017.examples;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Chapter017DatesAndTimes {
    @Test
    public void calculateTheNanoTimeThatATaskTakes() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println("Current time: " + System.nanoTime());
        }
        long endTime = System.nanoTime();
        System.out.println("Total time: " + (endTime - startTime));
    }

    @Test
    public void useCurrentTimeMillisToCreateAnUniqueNameWithNoNumbers() {
        String characters = "abcdefghij";
        String currentTime = "" + System.currentTimeMillis();
        String randomString = "";
        for (int i = 0; i < currentTime.length(); i++) {
            char index = currentTime.charAt(i);
            int indexInt = index - 48;
            // '0' = 48, '1' = 49, ...
            randomString += characters.charAt(indexInt);
        }
        System.out.println(randomString);
        assertEquals(randomString.length(), currentTime.length());
        for (int i = 0; i < 10; i++) {
            assertTrue(!randomString.contains("" + i));
        }
    }

    @Test
    public void calendarObject() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
    }
}
