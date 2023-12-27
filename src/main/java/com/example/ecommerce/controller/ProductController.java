package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findOne(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        try {
            Product createdProduct = productService.create(product.getProduct_name(), product.getPrice(), product.getStock());
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            Product updatedProductResult = productService.update(id, updatedProduct.getProduct_name(), updatedProduct.getPrice(), updatedProduct.getStock());
            return new ResponseEntity<>(updatedProductResult, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }
}
