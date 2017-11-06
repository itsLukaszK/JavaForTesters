package com.javafortesters.chap019.examples;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Chapter019Files {
    @Test
    public void createATempFileAndVaryTheParameters() throws IOException {
        File file = File.createTempFile("tempFile", null);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        for (int i = 0; i < 10; i++) {
            writer.println("Line" + (i + 1));
        }
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        } finally {
            reader.close();
        }
    }

    @Test
    public void writeOutTheRoots() {
        File[] roots = File.listRoots();
        System.out.println(roots);
        for (File file :
                roots) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @Test
    public void createATemporaryFileWithCustomCode() throws IOException {
        String systemTemporaryDirectory = System.getProperty("java.io.tmpdir");
        File file = new File(systemTemporaryDirectory, System.currentTimeMillis() + ".txt");
        file.createNewFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        assertTrue(file.exists());
        file.delete();
        assertFalse(file.exists());
    }

    @Test
    public void checkCanonicalConvertion() throws IOException {
        File path1 = new File("C:/1/2/3/4/../../..");
        File path2 = new File("C:/1/2/../../1");
        File canonicalPath = new File("C:/1");
        path1.createNewFile();
        path2.createNewFile();
        System.out.println(path1.getAbsolutePath());
        System.out.println(path2.getAbsolutePath());
        System.out.println(path1.getCanonicalPath());
        System.out.println(path2.getCanonicalPath());
        assertEquals(path1.getCanonicalPath(), path2.getCanonicalPath());
        assertEquals(canonicalPath.getCanonicalPath(), path1.getCanonicalPath());
    }
}
