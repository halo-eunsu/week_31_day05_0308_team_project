package com.nhnacademy.shoppingmall.entity.cartProduct;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CartProduct")
@Getter
@Setter
public class CartProduct {

    @EmbeddedId
    private Pk pk;

    @Column(name = "Quantity")
    private int quantity;

    @Embeddable
    @EqualsAndHashCode
    public static class Pk implements Serializable {

        @JoinColumn(name = "CartId")
        private int cartId;
        @JoinColumn(name = "ProductId")
        private String userId;

    }
}
