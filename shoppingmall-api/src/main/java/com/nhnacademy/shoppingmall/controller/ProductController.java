package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.product.ProductRepository;
import com.nhnacademy.shoppingmall.entity.product.Products;
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
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @PostMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable int productId) {
        Optional<Products> optionalProducts = repository.findById(productId);
        if (optionalProducts.isPresent()) {
            Products product = optionalProducts.get();
            HashMap<String, String> resp = new HashMap<>();
            resp.put("description", product.getDescription());
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid ProductId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }
}
