package com.javafortesters.domainentities;


import com.javafortesters.domainobject.TestAppEnv;

public class User {
    private String username;
    private String password;


    public User() {
        this("username", "Passw0rd", false);
    }

    private User(String username, String password, boolean b) {
        this.username = username;
        try {
            setPassword(password);
        } catch (InvalidPassword e) {
            throw new IllegalArgumentException("Default password incorrect ", e);
        }
    }

    public User(String username, String password) throws InvalidPassword {
        this.username = username;
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPassword {
        if (password.length() < 7) {
            throw new InvalidPassword("Password must be >6 chars");
        }

        String doesContainADigit = ".*[0-9]+.*";
        String doesContainAnUppercase = ".*[A-Z]+.*";

        if (!password.matches(doesContainADigit) || !password.matches(doesContainAnUppercase)) {
            throw new InvalidPassword("Password must contain one or more digit and uppercase");
        }
        this.password = password;
    }

    public String getUrl() {
        return TestAppEnv.getUrl();
    }

    public String getPermission() {
        return "Normal";
    }
}
