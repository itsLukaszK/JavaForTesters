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

    @Test
    public void showTheDistribution() {
        Random random = new Random();
        double randomGaussian;
        double oneStandardDeviation = 0;
        double twoStandardDeviation = 0;
        double threeStandardDeviation = 0;
        double fourStandardDeviation = 0;
        for (int i = 0; i < 1000; i++) {
            randomGaussian = random.nextGaussian();
            if (Math.abs(randomGaussian) <= 4.0d) {
                fourStandardDeviation++;
                if (Math.abs(randomGaussian) <= 3.0d) {
                    threeStandardDeviation++;
                    if (Math.abs(randomGaussian) <= 2.0d) {
                        twoStandardDeviation++;
                        if (Math.abs(randomGaussian) <= 1.0d) {
                            oneStandardDeviation++;
                        }
                    }
                }
            }
        }
        System.out.println("About 70% one standard deviation = " + oneStandardDeviation / 1000f * 100f);
        System.out.println("About 95% two standard deviation = " + twoStandardDeviation / 1000f * 100f);
        System.out.println("About 99% three standard deviation = " + threeStandardDeviation / 1000f * 100f);
        System.out.println("About 99.9% four standard deviation = " + fourStandardDeviation / 1000f * 100f);
    }

    @Test
    public void generate1000AgesUsingNextGaussian() {
        Random random = new Random();
        List<Double> randomDoubles = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randomDoubles.add(random.nextGaussian() * 5 + 35);
        }
        for (int i = 0; i <= 100; i++) {
            int temp = 0;
            for (int j = 0; j < 1000; j++) {
                if (i == randomDoubles.get(j).intValue()) {
                    temp++;
                }
            }
            System.out.println(i + " : " + temp);
        }
    }
}


