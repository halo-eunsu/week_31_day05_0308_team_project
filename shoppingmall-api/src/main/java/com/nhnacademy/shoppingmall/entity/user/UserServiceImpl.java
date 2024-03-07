package com.nhnacademy.shoppingmall.entity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<List<User>> getUsers() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new IllegalStateException("이미 존재하는 ID: " + user.getId());
        }
        return Optional.of(userRepository.save(user));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
