package com.chat.migration.data;

import com.chat.domain.model.Role;

import java.util.Arrays;
import java.util.List;

public class RolePopulation {

    private static final List<Role> roles = Arrays.asList(
            new Role(Long.valueOf(0),"ROLE_ADMIN"),
            new Role(Long.valueOf(0), "ROLE_USER")
    );


    public static List<Role> getRoles() {
        return roles;
    }
}
