package com.eeshania.application.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(generator = MyGenerator.generatorName, strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    private String name;
    private double price;
    private String imageUrl;








    // Constructors


    public Product(String name, String imageUrl, double price) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;

    }

    // Getters and setters




}
