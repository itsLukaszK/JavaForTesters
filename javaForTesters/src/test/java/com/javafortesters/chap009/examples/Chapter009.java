package com.javafortesters.chap009.examples;

import com.javafortesters.domainentities.InvalidPassword;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Chapter009 {
    @Test
    public void createAnArrayOfUsers() throws InvalidPassword {
        User[] users = new User[3];
        users[0] = new User("User1", "Password1");
        users[1] = new User("User2", "Password2");
        users[2] = new User("User3", "Password3");

        assertEquals("User1", users[0].getUsername());
        assertEquals("User2", users[1].getUsername());
        assertEquals("User3", users[2].getUsername());

        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void createAnArrayOf100Users() throws InvalidPassword {
        User[] users100 = new User[100];
        int j = 1;
        for (int i = 0; i < users100.length; i++) {

            users100[i] = new User("user" + j, "password" + j);
            j++;
        }
        assertEquals("user100", users100[99].getUsername());
        assertEquals("password100", users100[99].getPassword());
    }

    @Test
    public void sortWorkdaysArrayAndAssertResult() {
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Arrays.sort(workdays);
        assertEquals("Friday", workdays[0]);

        String[] workdaysMixedCase = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(workdaysMixedCase);
        assertEquals("monday", workdaysMixedCase[3]);
    }

    public void print2DIntArray(int[][] multi) {
        for (int[] outer : multi) {
            if (outer == null) {
                System.out.print("null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createATriangle() {
        int[][] multi = new int[16][];
        for (int i = 0; i < 16; i++) {
            multi[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                multi[i][j] = j;
            }
        }
        print2DIntArray(multi);
    }


}
