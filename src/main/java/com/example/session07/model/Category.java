package com.example.session07.model;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cateName", nullable = false, unique = true, length = 50)
    private String cateName;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "status")
    private boolean status;



}
