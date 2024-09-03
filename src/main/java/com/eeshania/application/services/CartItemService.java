package com.eeshania.application.services;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.Product;
import com.eeshania.application.repositories.CartItemRepository;
import com.eeshania.application.repositories.ProductRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
@Service
public class CartItemService {

    @Autowired
CartItemRepository cartItemRepository;
@Autowired
ProductRepository productRepository;
    CartItem cartItem = new CartItem();
   List<CartItem> cartItems = new java.util.ArrayList<>();

    public void save(Product product) {


        boolean exists;
        if(cartItemRepository.findCartItemByProduct ( product ) == null) exists = false;
        else exists = true;
        if(!exists) {
            CartItem cartItemNew= new CartItem();
            cartItemNew.setProduct ( product );
            cartItemNew.setQuantity ( 1 );
            cartItemRepository.save ( cartItemNew );
        }
        else {
             int quantity = cartItemRepository.findCartItemByProduct ( product ).getQuantity ()+ 1;

            cartItem= cartItemRepository.findCartItemByProduct ( product );
            cartItem.setQuantity ( quantity );

        }
        cartItems.add ( cartItem );

        cartItemRepository.save ( cartItem );
       // cartItemRepository.saveAll ( cartItems );


    }


    public List<CartItem> listAll() {


        return cartItemRepository.findAll (); }


    public CartItem increaseQuantity( int id ) {
        cartItem = cartItemRepository.findById ( (long) id ).get();

        cartItem.setQuantity ( cartItem.getQuantity () + 1 );
        cartItemRepository.save ( cartItem );
        return cartItem;
    }

    public CartItem decreaseQuantity( int id ) {
        cartItem = cartItemRepository.findById ( (long) id ).get();
        if(cartItem.getQuantity () > 1) {
            cartItem.setQuantity ( cartItem.getQuantity () - 1 );
            cartItemRepository.save ( cartItem );
        }
        return cartItem;
    }

}