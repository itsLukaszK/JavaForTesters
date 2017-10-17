package com.javafortesters.chap016.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static org.junit.Assert.assertTrue;

public class Chapter016RandomData {

    @Test
    public void confirmRandomLimits() {
        Random random = new Random();
        int randomInt;
        boolean randomBoolean;
        long randomLong;
        float randomFloat;
        double randomDouble;
        byte[] randomByte = new byte[100];
        int subRandomInt;

        for (int i = 0; i < 1000; i++) {
            randomInt = random.nextInt();
            assertTrue(randomInt >= Integer.MIN_VALUE && randomInt <= Integer.MAX_VALUE);

            randomBoolean = random.nextBoolean();
            assertTrue(randomBoolean == true || randomBoolean == false);

            randomLong = random.nextLong();
            assertTrue(randomLong >= Long.MIN_VALUE && randomLong <= Long.MAX_VALUE);

            randomFloat = random.nextFloat();
            assertTrue(randomFloat >= 0.0f && randomFloat < 1.0f);

            randomDouble = random.nextDouble();
            assertTrue(randomDouble >= 0.0d && randomDouble <= 1.0d);

            random.nextBytes(randomByte);
            assertTrue(randomByte.length == 100);

            randomInt = abs(randomInt);
            subRandomInt = random.nextInt(randomInt);
            assertTrue(subRandomInt >= 0 && subRandomInt <= randomInt - 1);

            if (i == 999) {
                System.out.println(randomLong);
                System.out.println(randomFloat);
                System.out.println(randomDouble);
                System.out.println(randomByte);
            }
        }
    }

    @Test
    public void generateNumbersBetween15And20() {
        Random random = new Random();
        int minValue = 15;
        int maxValue = 20;
        List<Integer> randomIntegers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            randomIntegers.add(random.nextInt(maxValue - minValue + 1) + minValue);
        }

        for (int i = minValue; i <= maxValue; i++) {
            assertTrue(randomIntegers.contains(i));
            System.out.println(i);
        }
    }
}

