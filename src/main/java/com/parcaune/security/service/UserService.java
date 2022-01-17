package com.parcaune.security.service;

import com.parcaune.security.domain.User;
import com.parcaune.security.domain.Role;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
