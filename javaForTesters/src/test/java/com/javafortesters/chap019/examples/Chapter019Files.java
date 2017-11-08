package com.javafortesters.chap019.examples;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;

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

    @Test
    public void checkThatTheTempDirectoryIsADirectory() {
        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
        assertTrue(tempDirectory.isDirectory());
        assertFalse(tempDirectory.isFile());
    }

    @Test
    public void writeToAPrintWriterThenAppend() throws IOException {
        File file = File.createTempFile(String.valueOf(System.currentTimeMillis()), null);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(System.currentTimeMillis());
        printWriter.println("---");
        printWriter.close();
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(writer);
        PrintWriter printWriter1 = new PrintWriter(bufferedWriter1);
        long nanoTime = System.nanoTime();
        printWriter1.println(nanoTime);
        printWriter1.close();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) System.out.println(line);
        } finally {
            bufferedReader.close();
        }
        assertEquals(String.valueOf(System.currentTimeMillis()).length() + 3 + String.valueOf(nanoTime).length() + 3 * System.lineSeparator().length(), file.length());
    }

    @Test
    public void useListFilesToShowTheTempDirectoryContents() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File tempDirFiles[] = tempDir.listFiles();
        for (File file :
                tempDirFiles) {
            if (file.isDirectory()) {
                System.out.println("DIR: " + file.getName());
            } else System.out.println("FIL: " + file.getName());
            System.out.println("Is the directory/file readable? " + file.canRead());
            System.out.println("Is the directory/file writable? " + file.canWrite());
            System.out.println("Is the directory/file executable? " + file.canExecute());
            System.out.println("The directory/file was modified on " + file.lastModified());
            System.out.println("");
        }
    }

    @Test
    public void copyAndMoveAFile() throws IOException {
        File file = File.createTempFile("file", ".txt");
        File copiedFile = new File("C:", "Files" + File.separator + file.getName());
        copiedFile.createNewFile();
        File movedFile = new File("C:", "Files" + File.separator + "movedFile.txt");
        movedFile.createNewFile();
        Files.copy(file.toPath(), copiedFile.toPath(), COPY_ATTRIBUTES, REPLACE_EXISTING);
        Files.move(file.toPath(), movedFile.toPath(), REPLACE_EXISTING, ATOMIC_MOVE);
    }
}
