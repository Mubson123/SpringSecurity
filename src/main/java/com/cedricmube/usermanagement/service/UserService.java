package com.cedricmube.usermanagement.service;

import com.cedricmube.usermanagement.domain.Role;
import com.cedricmube.usermanagement.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
