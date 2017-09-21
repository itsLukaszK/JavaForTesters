package com.javafortesters.chap010.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Chapter010 {
    @Test
    public void useAForLoopInsteadOfAWhileLoop() {
        String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};
        List<String> days = Arrays.asList(someDays);
        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        assertEquals("Monday is at position 3", 3, count);

        int i;
        for (i = 0; !days.get(i).equals("Monday"); i++) {
        }
        assertEquals("Monday is at position 3", 3, i);
    }

    @Test
    public void collectionOfUsers() {
        Collection<User> users = new ArrayList<>();
        assertEquals(0, users.size());
        assertEquals(true, users.isEmpty());
        User user1 = new User();
        User user2 = new User();
        users.add(user1);
        users.add(user2);
        assertEquals(2, users.size());
        assertEquals(false, users.isEmpty());
        Collection<User> users2 = new ArrayList<>();
        User user3 = new User();
        User user4 = new User();
        users2.add(user3);
        users2.add(user4);
        users.addAll(users2);
        assertEquals(true, users.containsAll(users2));
        users2.removeAll(users2);
        assertTrue(users2.isEmpty());
        assertTrue(users.size() == 4);
        users.clear();
    }

    @Test
    public void listOfUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("username1","password1");
        User user2 = new User("username2","password2");
        users.add(user1);
        users.add(0,user2);
        assertEquals(0, users.indexOf(user2));
        assertEquals(1, users.indexOf(user1));
        users.remove(user2);
        assertEquals(0, users.indexOf(user1));
    }

    @Test
    public void setOfUsers(){
        Set<User> users = new HashSet<>();
        User user1 = new User("username1","password1");
        users.add(user1);
        users.add(user1);
        assertEquals(1, users.size());
    }
}
