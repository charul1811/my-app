package com.eeshania.application.repositories;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    CartItem findCartItemByProduct(Product product);


}
