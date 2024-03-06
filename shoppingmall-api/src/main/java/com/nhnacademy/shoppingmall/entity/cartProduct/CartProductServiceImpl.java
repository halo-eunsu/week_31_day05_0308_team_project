package com.nhnacademy.shoppingmall.entity.cartProduct;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartProductServiceImpl implements CartProductService{

    private CartProductRepository cartProductRepository;

    @Override
    public int getQuantity(CartProduct.Pk pk) {
        return cartProductRepository.findByPk(pk).getQuantity();
    }
}
