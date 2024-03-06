package com.nhnacademy.shoppingmall.entity.order;

import com.nhnacademy.shoppingmall.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    Orders findByOrderId(int orderId);
}
