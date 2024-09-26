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

                      new Product ("Gold","https://www.orra.co.in/media/catalog/product/cache/fae84d45891aba1e98b5a417448a6ddb/o/p/opd24g03_copy.jpg",2599.5),
                      new Product("Diamondl","https://www.tanishq.co.in/on/demandware.static/-/Sites-Tanishq-product-catalog/default/dweea9fbc4/images/hi-res/51D3B1BGEAA00_2.jpg",2999.0),
                      new Product("silver","https://www.tanishq.co.in/on/demandware.static/-/Sites-Tanishq-product-catalog/default/dwe4bf267c/images/hi-res/510122FAAAA00_1.jpg",2289.5),
                      new Product("silver","https://www.orra.co.in/media/catalog/product/cache/fae84d45891aba1e98b5a417448a6ddb/o/p/opd24g03_copy.jpg",2179.5),
                      new Product("silver","https://www.tanishq.co.in/on/demandware.static/-/Sites-Tanishq-product-catalog/default/dw639a9719/images/hi-res/5031202KTAGA02_2.jpg",1899.5)
           ));




          System.out.println("----------All Data saved into Database----------------------");
          }


    void saveProduct(Product product) {
         eRepo.save(product);

    }

}