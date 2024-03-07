package com.nhnacademy.shoppingmall.entity.order;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Setter
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;

    @Override
    public Optional<Orders> getOrders(int orderId) {
        return repository.findByOrderId(orderId);

    }
}
