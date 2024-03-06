package com.nhnacademy.shoppingmall.entity.prodcutCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategories, ProductCategories.Pk> {
    List<ProductCategories> getAllByPk(ProductCategories.Pk pk);

    @Override
    List<ProductCategories> findAllById(Iterable<ProductCategories.Pk> pks);
}
