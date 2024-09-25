package com.eeshania.application.controller;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.Product;
import com.eeshania.application.repositories.CartItemRepository;
import com.eeshania.application.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {
   @Autowired
    CartItemService cartItemService;
   @Autowired
   CartItemRepository cartItemRepository;



    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        cartItemService.save(product);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public List<CartItem> listAll() {
    System.out.println(cartItemRepository.findAll ());
        return cartItemRepository.findAll ();
    }


}
