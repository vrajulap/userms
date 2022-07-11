package com.venkat.userms.service;

import java.util.List;
import java.util.Optional;

import com.venkat.userms.model.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    User createUser(User user);
    void deleteUser(Long userId);
}
