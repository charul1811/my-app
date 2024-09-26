package com.eeshania.application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private List<CartItem> Items;


    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}