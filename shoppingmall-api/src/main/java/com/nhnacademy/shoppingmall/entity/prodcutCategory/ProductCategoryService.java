package com.nhnacademy.shoppingmall.entity.prodcutCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategories> getProductCategory(ProductCategories.Pk pk);

}
