package com.nhnacademy.shoppingmall.entity.prodcutCategory;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategories> getProductCategory(ProductCategories.Pk pk) {
        return repository.getAllByPk(pk);
    }
}
