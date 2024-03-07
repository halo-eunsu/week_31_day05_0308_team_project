package com.nhnacademy.shoppingmall.entity.user;

import com.nhnacademy.shoppingmall.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String id);
    Optional<List<User>> getUsers();

    Optional<User> createUser(User user);
    void deleteUser(String id);
}
