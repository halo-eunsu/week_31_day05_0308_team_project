package com.nhnacademy.shoppingmall.entity.order;

import com.nhnacademy.shoppingmall.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    Optional<Orders> findByOrderId(int orderId);
}
