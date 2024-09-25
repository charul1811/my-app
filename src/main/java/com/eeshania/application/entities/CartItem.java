package com.eeshania.application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity=1;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName, strategy = GenerationType.SEQUENCE)
    private Long id;
    private double totalPrice;


    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public  void setTotalPrice() {
        this.totalPrice= (this.unitPrice() * this.quantity);
    }

    private int unitPrice() {
        return (int) this.product.getPrice();
    }

}
