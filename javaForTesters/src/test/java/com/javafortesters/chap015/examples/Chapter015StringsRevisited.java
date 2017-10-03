package com.javafortesters.chap015.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
}
