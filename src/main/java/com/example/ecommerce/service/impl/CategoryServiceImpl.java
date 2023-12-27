package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    @Override
    public Category findById(Integer id){
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @Override
    public Category create(String category_name) {
        Category category = new Category(category_name);

        if(category_name.isEmpty()){
            throw new IllegalArgumentException();
        }
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(Integer id, Category category){
        if (id == null) {
            throw new IllegalArgumentException();
        }

        Optional<Category> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isPresent()) {
            Category updatedCategory = new Category();
            updatedCategory.setCategory_name(category.getCategory_name());
            return categoryRepository.save(updatedCategory);
        }
        return null;
    }

    @Override
    public void delete(Integer id){
        if(id == null) {
            throw new IllegalArgumentException();
        }

        categoryRepository.deleteById(id);
    }
}
