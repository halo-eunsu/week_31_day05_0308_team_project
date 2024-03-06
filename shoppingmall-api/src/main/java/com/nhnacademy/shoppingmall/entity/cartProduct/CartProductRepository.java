package com.nhnacademy.shoppingmall.entity.cartProduct;

import com.nhnacademy.shoppingmall.entity.cartProduct.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProduct.Pk> {
    CartProduct findByPk(CartProduct.Pk pk);
}
