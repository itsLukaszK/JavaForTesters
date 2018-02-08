package com.javafortesters.temp_tests;

import org.junit.Test;

public class TempTests {
    @Test
    public void tryCatch() {
        int tab[] = {1, 2, 3, 4, 5};
//        Scanner scanner = new Scanner(System.in);
        int index = -1;

//        System.out.println("Podaj indeks tablicy, który chcesz zobaczyć: ");
//        index = scanner.nextInt();

        try {
            System.out.println(tab[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}
