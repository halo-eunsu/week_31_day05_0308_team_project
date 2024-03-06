package com.nhnacademy.shoppingmall.entity.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository repository;

    @Override
    public OrderDetails getOrderDetail(int orderDetailId) {
        return repository.findById(orderDetailId).get();
    }

}
