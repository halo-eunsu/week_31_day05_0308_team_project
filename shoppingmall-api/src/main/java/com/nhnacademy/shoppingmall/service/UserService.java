package com.nhnacademy.shoppingmall.service;

import com.nhnacademy.shoppingmall.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<Optional<User>> getUser(String id);
    Optional<List<User>> getUsers();

    Optional<User> createUser(User user);
    void deleteUser(String id);
}
