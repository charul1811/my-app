package com.eeshania.application.services;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.ShoppingCart;
import com.eeshania.application.repositories.CartItemRepository;
import com.eeshania.application.repositories.ShoppingCartRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@BrowserCallable
@AnonymousAllowed
@Service
public class ShoppingCartService {
    ShoppingCartRepository shoppingCartRepository;
@Autowired
CartItemRepository cartItemRepository;
    public void save(CartItem [] cartItems) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems( List.of ( cartItems ) );
        shoppingCartRepository.save(shoppingCart);
    }
    public List<CartItem> listAll() {
        return cartItemRepository.findAll ();
    }
    /*public double getTotal(long id) {
        shoppingCartRepository.findById(id);

        return shoppingCartRepository.findById(id).get().getTotal();


    }*/
    public  ShoppingCart getShoppingCart(long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        double total = shoppingCart.getTotal();
        shoppingCart.setTotal(total);
        return shoppingCartRepository.save(shoppingCart);
    }


}
