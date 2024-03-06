package com.nhnacademy.shoppingmall.entity.address;

import com.nhnacademy.shoppingmall.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByUser(User user);
}
