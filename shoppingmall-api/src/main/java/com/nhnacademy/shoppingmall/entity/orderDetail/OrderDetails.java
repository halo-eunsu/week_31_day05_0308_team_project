package com.nhnacademy.shoppingmall.entity.orderDetail;

import com.nhnacademy.shoppingmall.entity.order.Orders;
import com.nhnacademy.shoppingmall.entity.product.Products;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

    @Id
    @Column(name = "OrderDetailID")
    private int orderDetailId;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products products;
}
