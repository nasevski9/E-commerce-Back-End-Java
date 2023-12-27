package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Product findById(Integer id){
        Product product = productRepository.findById(id).get();
        return product;
    }
    @Override
    public Product create(String name, Double price, Integer stock){
        if(name.isEmpty() || price == null || stock == null){
            throw new IllegalArgumentException();
        }

        Product product = new Product(name, price, stock);
        productRepository.save(product);
        return product;

    }
    @Override
    public Product update(Long id, String name, Double price, Integer stock) {
        // Check if the provided values are valid
        if (id == null || name.isEmpty() || price == null || stock == null) {
            throw new IllegalArgumentException();
        }

        // Find the existing product by ID
        Product existingProduct = productRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        // Update the fields of the existing product
        existingProduct.setProduct_name(name);
        existingProduct.setPrice(price);
        existingProduct.setStock(stock);

        // Save the updated product
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
