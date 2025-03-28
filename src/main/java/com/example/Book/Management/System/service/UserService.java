package com.example.Book.Management.System.service;

import com.example.Book.Management.System.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
