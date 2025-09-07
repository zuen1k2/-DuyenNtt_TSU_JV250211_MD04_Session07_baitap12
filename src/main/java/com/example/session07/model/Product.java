package com.example.session07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String description;
    private Double price;
    private Long categoryId;

}
