package com.nhnacademy.shoppingmall.entity.category;

public interface CategoryService {
    void create(String categoryName);
    void delete(int id);
    void changeCategoryName(int id, String name);
    Categories getCategory(int id);
}
