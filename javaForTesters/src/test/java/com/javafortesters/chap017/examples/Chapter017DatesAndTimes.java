package com.javafortesters.chap017.examples;

import org.junit.Test;

import java.util.Calendar;

import static java.util.Calendar.JANUARY;
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

    @Test
    public void useTheOtherCalendarConstants() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.DECEMBER, 15, 23, 49, 54);
        assertEquals(calendar.get(Calendar.MONTH), 11);
        assertEquals(calendar.get(Calendar.YEAR), 2013);
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), 15);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), 23);
        assertEquals(calendar.get(Calendar.MINUTE), 49);
        assertEquals(calendar.get(Calendar.HOUR), 11);
        assertEquals(calendar.get(Calendar.AM_PM), Calendar.PM);
        //Other constants:
        assertEquals(calendar.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY);
        assertEquals(calendar.get(Calendar.WEEK_OF_MONTH), 2);
        assertEquals(calendar.get(Calendar.DAY_OF_WEEK), 1);
        assertEquals(calendar.get(Calendar.WEEK_OF_YEAR), 50);
        assertEquals(calendar.get(Calendar.DAY_OF_YEAR), 349);
        //Increment and decrement fields:
        calendar.add(Calendar.DAY_OF_MONTH, -12);
        calendar.add(Calendar.MONTH, -6);
        calendar.add(Calendar.YEAR, -2);
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), 3);
        assertEquals(calendar.get(Calendar.MONTH), Calendar.JUNE);
        assertEquals(calendar.get(Calendar.YEAR), 2011);
    }

    @Test
    public void confirmAddMovesTheYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.DECEMBER, 23);
        calendar.roll(Calendar.DAY_OF_MONTH, 17);
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), 9);
        assertEquals(11, calendar.get(Calendar.MONTH));
        assertEquals(2013, calendar.get(Calendar.YEAR));
        calendar.roll(Calendar.DAY_OF_MONTH, -17);
        calendar.add(Calendar.DAY_OF_MONTH, 17);
        assertEquals(JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(2014, calendar.get(Calendar.YEAR));
    }
}
