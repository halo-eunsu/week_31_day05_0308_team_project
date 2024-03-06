package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.shoppingCart.ShoppingCart;
import com.nhnacademy.shoppingmall.entity.shoppingCart.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    private final ShoppingCartRepository cartRepository;

    @PostMapping("/{cartId}")
    public ResponseEntity<?> getShoppingCart(@PathVariable int cartId) {
        Optional<ShoppingCart> optionalCart= cartRepository.getShoppingCartByCartId(cartId);
        if (optionalCart.isPresent()) {
            ShoppingCart cart = optionalCart.get();

            HashMap<String, String> resp = new HashMap<>();
            resp.put("userId", cart.getUserId());
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid ShoppingCartId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }
}
