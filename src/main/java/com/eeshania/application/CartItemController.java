package com.eeshania.application;

import com.eeshania.application.entities.Product;
import com.eeshania.application.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
   @Autowired
    CartItemService cartItemService;



    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        cartItemService.save(product);

        return ResponseEntity.ok().build();
    }


}
