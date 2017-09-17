package com.javafortesters.chap009.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chapter009 {
    @Test
    public void createAnArrayOfUsers() {
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
    public void createAnArrayOf100Users() {
        User[] users100 = new User[100];
        int j = 1;
        for (int i = 0; i < users100.length; i++) {

            users100[i] = new User("user" + j, "password" + j);
            j++;
        }
        assertEquals("user100", users100[99].getUsername());
        assertEquals("password100", users100[99].getPassword());
    }

}
