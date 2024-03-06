package com.nhnacademy.shoppingmall.entity.product;

public interface ProductService {
    void createProduct(Products products);
    void updateProduct(Products products);
    void delete(int productId);
    Products getProduct(int productId);

}
