package com.javafortesters.domainentities;

public class AdminUser extends User {

    @Override
    public String getPermission() {
        return "Elevated";
    }

    public AdminUser() throws InvalidPassword {
        this("adminuser", "password");
    }

    public AdminUser(String username, String password) throws InvalidPassword {
        super(username, password);
    }
}
