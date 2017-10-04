package com.javafortesters.chap015.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class Chapter015StringsRevisited {
    @Test
    public void escapeCharacters() {
        System.out.println("Tab\t Backspace\b A carriage return\r");
        System.out.println("New line\n");
        System.out.println("A carriage return\r");
        System.out.println("The end");
    }

    @Test
    public void constructString() {
        String abcde = "abcde";
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        byte[] bytes = "abcde".getBytes();
        System.out.println(bytes);
        String abcdeFromString = new String(abcde);
        assertThat(abcdeFromString, equalTo(abcde));
        String abcdeFromChar = new String(chars);
        assertThat(abcdeFromChar, equalTo(abcdeFromString));
        String abcdeFromBytes = new String(bytes);
        assertThat(abcdeFromBytes, is("abcde"));
    }

    @Test
    public void useRegionMatches() {
        String hello = "Hello fella";
        String young = "young lady";
        assertTrue(hello.regionMatches(9, young, 6, 2));
    }

    public void findPositionsOfAllOccurrencesInAString(String string, String substring) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int substringLocation = string.indexOf(substring, i);
            if (substringLocation == -1) break;
            integerList.add(substringLocation);
            i = substringLocation;
        }
        System.out.println(integerList);
    }

    @Test
    public void findPositionsOfAllOccurrencesInAHelloString() {
        findPositionsOfAllOccurrencesInAString("Hello fella", "l");
    }

}
