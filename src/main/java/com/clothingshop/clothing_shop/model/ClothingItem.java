package com.clothingshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //defines the class as an entity
public class ClothingItem {

    @Id //defines the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //says that id should be generated automatically
    private Long id;
    private String name;
    private String size;
    private Double price;

    // Constructors
    public ClothingItem() {}

    public ClothingItem(String name, String size, Double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
