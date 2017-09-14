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

        assertEquals("User1",users[0].getUsername());
        assertEquals("User2",users[1].getUsername());
        assertEquals("User3",users[2].getUsername());
    }


}
