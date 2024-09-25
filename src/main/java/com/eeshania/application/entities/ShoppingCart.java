package com.eeshania.application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    private double total=0;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private List<CartItem> items;

/*public void setTotal() {
    double total = 0;
    for (CartItem item : items) {
        total = total + item.getTotalPrice();
        total = BigDecimal.valueOf(total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.setTotal(total);
    }
    this.total = total;
}*/

    public void removeItem(CartItem item) {
    items.remove(item);
   }
public void addItem(CartItem item) {
    items.add(item);
    item.setShoppingCart(this);
}


    // Constructors


    // Getters and setters



}
