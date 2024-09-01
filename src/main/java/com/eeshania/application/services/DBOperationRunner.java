package com.eeshania.application.services;


import com.eeshania.application.entities.Product;
import com.eeshania.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBOperationRunner implements CommandLineRunner {

     @Autowired
     ProductRepository eRepo;

     @Override
     public void run(String... args) throws Exception {

           eRepo.saveAll( Arrays.asList(

                      new Product ("Isabel","https://www.orra.co.in/media/catalog/product/cache/fae84d45891aba1e98b5a417448a6ddb/o/p/opd24g03_copy.jpg",2599.5),
                      new Product("Michael","https://www.orra.co.in/media/catalog/product/cache/fae84d45891aba1e98b5a417448a6ddb/o/p/opd24g03_copy.jpg",2999.0),
                      new Product("Thomas","https://www.orra.co.in/media/catalog/product/cache/fae84d45891aba1e98b5a417448a6ddb/o/p/opd24g03_copy.jpg",2699.5)

           ));




          System.out.println("----------All Data saved into Database----------------------");
          }


    void saveProduct(Product product) {
         eRepo.save(product);

    }

}