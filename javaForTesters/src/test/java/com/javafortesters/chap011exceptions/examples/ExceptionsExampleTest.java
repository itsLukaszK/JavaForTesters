package com.javafortesters.chap011exceptions.examples;

import com.javafortesters.domainentities.InvalidPassword;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsExampleTest {
    @Test //(expected = NullPointerException.class)
    public void throwANullPointerException() {
        Integer age = null;
        String ageAsString;
        String yourAge = "";

        try {
            ageAsString = age.toString();
        } catch (NullPointerException e) {
            System.out.println("getMessage - " + e.getMessage());
            System.out.println("getStackTrace - " + e.getStackTrace());
            System.out.println("printStackTrace");
            e.printStackTrace();

            age = 18;
            ageAsString = age.toString();
        } finally {
            yourAge =
                    "You are " + age.toString() + " years old";
        }
        assertEquals("You are 18 years old", yourAge);
    }

    @Test
    public void throwAnUserException() throws InvalidPassword {
        User user1 = new User("user1", "passw1");
    }
}
