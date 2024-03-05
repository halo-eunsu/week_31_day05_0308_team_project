package com.nhnacademy.shoppingmall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "ModelNumber")
    private String modelNumber;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "ProductImage")
    private String image;

    @Column(name = "UnitCost")
    private BigDecimal unitCost;

    @Column(name = "Description")
    private String description;

}
