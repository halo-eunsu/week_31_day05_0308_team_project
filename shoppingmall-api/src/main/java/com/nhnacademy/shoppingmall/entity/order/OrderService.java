package com.nhnacademy.shoppingmall.entity.order;

import java.util.Optional;

public interface OrderService {
    Optional<Orders> getOrders(int orderId);

}
