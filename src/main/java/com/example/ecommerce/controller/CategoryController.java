package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
      return categoryService.findAll();
    };

    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.create(category.getCategory_name());
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category){
        try {
            categoryService.update(id, category);
            return new ResponseEntity<>(HttpStatus.OK);
        }  catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
    }
}
