package com.nhnacademy.shoppingmall.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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
