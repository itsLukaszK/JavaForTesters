package com.javafortesters.chap018.examples;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Chapter018PropertiesAndPropertyFiles {
    @Test
    public void createAndListAPropertiesObject() {
        Properties properties = new Properties();
        properties.setProperty("name", "bob");
        properties.setProperty("gender", "male");
        properties.setProperty("password", "paSSw0rd");
        assertEquals(3, properties.size());
        for (String key :
                properties.stringPropertyNames()) {
            System.out.println("Key: " + key + ", Value: " + properties.getProperty(key));
        }
        properties.list(System.out);
        assertTrue(properties.containsKey("gender"));
        assertEquals("bob", properties.getProperty("name"));
        assertEquals("default", properties.getProperty("permission", "default"));
    }

    @Test
    public void outputTheSystemPropertiesObject() {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

    @Test
    public void storeAndLoadASavedPropertiesFile() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempFilePath = tempDirectory + "tempFile.properties";
        FileOutputStream stream = new FileOutputStream(tempFilePath);
        properties.store(stream, "Elo");
        stream.close();
        FileReader reader = new FileReader(tempFilePath);
        Properties loaded = new Properties();
        try {
            loaded.load(reader);
        } finally {
            reader.close();
        }
        assertEquals("value1", loaded.getProperty("key1"));
        assertEquals("value2", loaded.getProperty("key2"));
        new File(tempFilePath).delete();
    }
}
