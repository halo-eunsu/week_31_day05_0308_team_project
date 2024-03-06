package com.nhnacademy.shoppingmall.entity.shoppingCart;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
@Getter
public class ShoppingCart {

    @Id
    @Column(name = "CartId")
    private int cartId;

    @Column(name = "user_id")
    private String userId;

}
