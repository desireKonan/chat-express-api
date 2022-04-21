package com.chat.services;

import java.util.List;
import java.util.UUID;

import com.chat.domain.model.Role;
import com.chat.domain.model.User;

public interface UserService {
    List<User> getUsers();
    User getUser(final UUID id);
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String role);
    User findUserByEmail(final String email);
    void deleteUser(final UUID id);
}
