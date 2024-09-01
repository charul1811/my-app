package com.eeshania.application.repositories;


import com.eeshania.application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



    Product findById(long productId);
}
