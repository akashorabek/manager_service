package com.example.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int quantity;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "in_stock")
    private boolean inStock;
}
