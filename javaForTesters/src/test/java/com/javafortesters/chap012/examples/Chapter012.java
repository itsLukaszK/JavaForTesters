package com.javafortesters.chap012.examples;

import com.javafortesters.domainentities.AdminUser;
import com.javafortesters.domainentities.ReadOnlyUser;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chapter012 {
    @Test
    public void UserComposedOfTestAppEnv() {
        User user = new User();
        System.out.println(user.getUrl());
    }

    @Test
    public void aUserHasNormalPermissions() {
        User user = new User();
        assertEquals("Normal", user.getPermission());
    }

    @Test
    public void anAdminUserDefaultConstructor() {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions() {
        AdminUser adminUser = new AdminUser("admin", "Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void createAReadOnlyUser() {
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        assertEquals("ReadOnly", readOnlyUser.getPermission());
        assertEquals("username", readOnlyUser.getUsername());
        assertEquals("password", readOnlyUser.getPassword());
    }
}
