package com.javafortesters.chap013.examples;

import com.javafortesters.domainentities.InvalidPassword;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Chapter013 {
    @Test
    public void canCreateDefaultUserWithoutHandlingException() {
        User user = new User();
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void haveToCatchIllegalPasswordForParamConstructor() {
        try {
            User user = new User("me", "wrong");
            fail("An exception should have been thrown");
        } catch (InvalidPassword invalidPassword) {
            assertTrue("The exception was thrown", true);
        }
    }

    @Test(expected = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User user = new User("username", "passwo");
    }

    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException() {
        User user = new User();
        assertEquals("password", user.getPassword());
    }

    @Test
    public void errorMessageThrownContainsTheText() {
        try {
            User user = new User("username", "passwo");
            fail("An InvalidPassword Exception should've been thrown");
        } catch (InvalidPassword invalidPassword) {
            System.out.println(invalidPassword.getMessage());
            invalidPassword.getMessage().startsWith("Password must be >6 chars");
        }
    }

    @Test
    public void theInvalidPasswordExceptionIsThrownOnSetPassword() {
        User user = new User();
        try {
            user.setPassword("Passwo");
            fail("An InvalidPassword Exception should've been thrown");
        } catch (InvalidPassword invalidPassword) {
            invalidPassword.getMessage().startsWith("Password must be >6 chars");
            invalidPassword.printStackTrace();
        }
    }
}
