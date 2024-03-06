package com.nhnacademy.shoppingmall.entity.shoppingCart;

import com.nhnacademy.shoppingmall.entity.shoppingCart.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart getShoppingCartByUserId(String userId);
    Optional<ShoppingCart> getShoppingCartByCartId(int cartId);
}
