package com.nhnacademy.accountapi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.
    }

    public User createAdmin(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword, List.of(User.ROLE.ROLE_ADMIN.name()));
    }

    public User createUser(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword,List.of(User.ROLE.ROLE_USER.name()));
    }

}
