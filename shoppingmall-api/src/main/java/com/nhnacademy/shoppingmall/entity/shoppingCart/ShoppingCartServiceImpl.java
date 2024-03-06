package com.nhnacademy.shoppingmall.entity.shoppingCart;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository repository;

    @Override
    public ShoppingCart getShoppingCart(String userId) {
        return repository.getShoppingCartByUserId(userId);
    }
}
