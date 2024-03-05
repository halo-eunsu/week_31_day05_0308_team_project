package com.nhnacademy.shoppingmall.entity;

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
