package com.nhnacademy.shoppingmall.entity.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    @Column(name = "CategoryName")
    private String categoryName;

}
