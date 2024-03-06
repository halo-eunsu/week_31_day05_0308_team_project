package com.nhnacademy.shoppingmall.entity.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Override
    public void createProduct(Products targetProducts) {
        repository.saveAndFlush(targetProducts);
    }

    @Override
    public void updateProduct(Products targetProducts) {
        Products targetProduct = repository.findById(targetProducts.getProductId()).get();
        targetProduct.setDescription(targetProducts.getDescription());
        targetProduct.setModelName(targetProducts.getModelName());
        targetProduct.setImage(targetProduct.getImage());
        targetProduct.setUnitCost(targetProducts.getUnitCost());
        targetProduct.setModelNumber(targetProducts.getModelNumber());
        repository.saveAndFlush(targetProduct);

    }

    @Override
    public void delete(int productId) {
        repository.deleteById(productId);
    }

    @Override
    public Products getProduct(int productId) {
        return repository.findById(productId).get();
    }
}
