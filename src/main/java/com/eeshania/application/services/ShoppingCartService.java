package com.eeshania.application.services;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.ShoppingCart;
import com.eeshania.application.repositories.ShoppingCartRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.stereotype.Service;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
@Service
public class ShoppingCartService {
    ShoppingCartRepository shoppingCartRepository;

    public void save(CartItem [] cartItems) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems( List.of ( cartItems ) );
        shoppingCartRepository.save(shoppingCart);
    }



}
