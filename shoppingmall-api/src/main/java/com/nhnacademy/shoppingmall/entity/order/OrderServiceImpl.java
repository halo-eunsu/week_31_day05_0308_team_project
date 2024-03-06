package com.nhnacademy.shoppingmall.entity.order;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;

    @Override
    public Orders getOrders(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
