package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    Category create(String category_name);

    Category update(Integer id, Category category);

    void delete(Integer id);
}