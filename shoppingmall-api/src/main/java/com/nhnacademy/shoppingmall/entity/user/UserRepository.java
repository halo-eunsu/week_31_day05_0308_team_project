package com.nhnacademy.shoppingmall.entity.user;

import com.nhnacademy.shoppingmall.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
