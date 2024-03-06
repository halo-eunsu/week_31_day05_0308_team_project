package com.nhnacademy.shoppingmall.entity.review;

import com.nhnacademy.shoppingmall.entity.product.Products;
import com.nhnacademy.shoppingmall.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findAllByProducts(Products products);
    List<Reviews> findAllByUser(User user);

}
