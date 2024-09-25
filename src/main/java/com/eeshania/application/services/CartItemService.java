package com.eeshania.application.services;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.Product;
import com.eeshania.application.entities.ShoppingCart;
import com.eeshania.application.repositories.CartItemRepository;
import com.eeshania.application.repositories.ProductRepository;
import com.eeshania.application.repositories.ShoppingCartRepository;
import com.eeshania.application.repositories.UserRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@BrowserCallable
@AnonymousAllowed
@Service
public class CartItemService {

    @Autowired
CartItemRepository cartItemRepository;
@Autowired
ProductRepository productRepository;
@Autowired
ShoppingCartRepository shoppingCartRepository;
@Autowired
ShoppingCartService shoppingCartService;
    CartItem cartItem = new CartItem();
   List<CartItem> cartItems = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;
    ShoppingCart shoppingCart = new ShoppingCart();


    public void save(Product product) {


        boolean exists;
        if(cartItemRepository.findCartItemByProduct ( product ) == null) exists = false;
        else exists = true;
        if(!exists) {
            CartItem cartItemNew= new CartItem();
            cartItemNew.setProduct ( product );
            cartItemNew.setQuantity ( 1 );
            cartItemRepository.save ( cartItemNew );
            cartItemNew.setShoppingCart(shoppingCart);
            cartItems.add ( cartItemNew );
            //cartItemNew.setTotalPrice();
            cartItemNew.getShoppingCart().setId(shoppingCart.getId());
            shoppingCart.setItems(cartItems);
            //shoppingCartRepository.save ( shoppingCart );

        }
        else {
             int quantity = cartItemRepository.findCartItemByProduct ( product ).getQuantity ()+ 1;

            cartItem= cartItemRepository.findCartItemByProduct ( product );
            cartItem.setQuantity ( quantity );
            cartItem.setShoppingCart(shoppingCart);
            cartItemRepository.save ( cartItem );
            cartItems.add ( cartItem );
            //cartItem.setTotalPrice();
            cartItem.getShoppingCart().setId(shoppingCart.getId());
            shoppingCart.setItems(cartItems);
            //shoppingCartRepository.save ( shoppingCart );


        }



       // cartItemRepository.saveAll ( cartItems );



    }
public void addToCart(long cartid,long productid, int quantity){

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart ( cartid );
        Product product = productRepository.findById ( productid );

        CartItem cartItem = shoppingCart.getItems().stream().
                filter(item -> item.getProduct().getId() == product.getId())
                .findFirst().orElse(new CartItem());

       if (cartItem.getId() == 0) {
           cartItem.setShoppingCart(shoppingCart);
           cartItem.setProduct(product);
           cartItem.setQuantity(quantity);
           cartItem.setTotalPrice();
           cartItemRepository.save(cartItem);
       }
       else {
           cartItem.setQuantity(cartItem.getQuantity() + quantity);
           cartItem.setTotalPrice();
           cartItemRepository.save(cartItem);
       }
       shoppingCart.addItem(cartItem);
       shoppingCartRepository.save(shoppingCart);


}

    public List<CartItem> listAll() {

            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setItems( cartItemRepository.findAll () );
            shoppingCartRepository.save(shoppingCart);
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

public  void removeItem( int id ) {
    cartItemRepository.deleteById ( (long) id );

    }}