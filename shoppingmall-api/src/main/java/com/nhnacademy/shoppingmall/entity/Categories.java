package com.nhnacademy.shoppingmall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @Column(name = "CategoryID")
    private int categoryId;

    @Column(name = "CategoryName")
    private String categoryName;
}
