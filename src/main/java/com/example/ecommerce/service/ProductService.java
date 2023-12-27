package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Integer id);
    Product create(String name, Double price, Integer stock);
    Product update(Long id, String name, Double price, Integer stock);
    void deleteByName(String name);
    void deleteById(Integer id);

}
