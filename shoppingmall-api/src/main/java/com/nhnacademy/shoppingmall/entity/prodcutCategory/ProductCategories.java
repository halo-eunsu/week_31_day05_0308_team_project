package com.nhnacademy.shoppingmall.entity.prodcutCategory;

import com.nhnacademy.shoppingmall.entity.category.Categories;
import com.nhnacademy.shoppingmall.entity.product.Products;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductCategories")
public class ProductCategories {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    public static class Pk implements Serializable {

        @ManyToOne
        @JoinColumn(name = "ProductID")
        private Products products;

        @ManyToOne
        @JoinColumn(name = "CategoryID")
        private Categories categories;
    }
}