package com.nhnacademy.shoppingmall.entity.order;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;

    @Override
    public Optional<Orders> getOrders(int orderId) {
        return repository.findByOrderId(orderId);

    }
}
