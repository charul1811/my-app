package com.eeshania.application.services;


import com.eeshania.application.entities.Product;
import com.eeshania.application.repositories.ProductRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@BrowserCallable
@AnonymousAllowed

public class ProductService {


    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public void save(Product product) {

        productRepository.save(product);
    }

    public List<Product> listAll() {
        return  productRepository.findAll (); }
}
