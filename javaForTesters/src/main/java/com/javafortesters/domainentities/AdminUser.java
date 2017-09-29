package com.javafortesters.domainentities;

public class AdminUser extends User {

    @Override
    public String getPermission() {
        return "Elevated";
    }

    public AdminUser(){
        this("adminuser", "password");
    }

    public AdminUser(String username, String password) {
        super(username, password);
    }
}
