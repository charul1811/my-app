package com.eeshania.application.repositories;

import com.eeshania.application.entities.CartItem;
import com.eeshania.application.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {







    CartItem findCartItemByProduct(Product product);
@Transactional
    @Modifying(flushAutomatically = true)
@Query("update CartItem c set c.quantity = ?2 where c.id = ?1")
void updateCartItemById(@Param ( "id" ) long id, @Param ( "quantity" ) int quantity);
}
