package com.eeshania.application.controller;

import com.eeshania.application.entities.Product;
import com.eeshania.application.repositories.ProductRepository;
import com.eeshania.application.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productRepository.save(product);
    return  ResponseEntity.ok("Product registered successfully");
    }
    @PostMapping("/add all")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productRepository.saveAll(products);
    }




}