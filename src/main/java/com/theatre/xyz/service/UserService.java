package com.theatre.xyz.service;

import com.theatre.xyz.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserByUsername(String username);
}

