package com.eeshania.application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {


    @OneToOne
    private Product product;

    private int quantity;

    @ManyToOne
    private ShoppingCart shoppingCart;

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName, strategy = GenerationType.SEQUENCE)
    private Long id;




    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
