package com.eeshania.application.controller;

import com.eeshania.application.entities.ShoppingCart;
import com.eeshania.application.repositories.ShoppingCartRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    @GetMapping
    public List<ShoppingCart> listAll() {
        return shoppingCartRepository.findAll();
    }

}
