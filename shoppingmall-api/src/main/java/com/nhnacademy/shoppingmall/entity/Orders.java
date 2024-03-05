package com.nhnacademy.shoppingmall.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "OrderID")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "ShipDate")
    private Date shipDate;
}
