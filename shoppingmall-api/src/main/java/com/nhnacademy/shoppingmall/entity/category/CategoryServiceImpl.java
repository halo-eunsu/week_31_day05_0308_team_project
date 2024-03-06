package com.nhnacademy.shoppingmall.entity.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public void create(String categoryName) {
        Categories category = new Categories();
        category.setCategoryName(categoryName);
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void changeCategoryName(int id, String name) {
        categoryRepository.findById(id).get().setCategoryName(name);
    }

    @Override
    public Categories getCategory(int id) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.findById(id).get();
        } else {
            throw new IllegalArgumentException("없는 카테고리 이므니다");
        }
    }
}
