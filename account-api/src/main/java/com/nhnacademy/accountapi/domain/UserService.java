package com.nhnacademy.accountapi.domain;

public interface UserService {

    void deleteUser(String id);
    void createUser(User user);

    User createAdmin(String userId, String userName, String userPassword);

    public User createUser(String userId, String userName, String userPassword);
}
