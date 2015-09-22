package com.realdolmen.beer.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // in liters
    private double inhoud;

    @Lob
    private String imageUrl;




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInhoud() {
        return inhoud;
    }

    public void setInhoud(double inhoud) {
        this.inhoud = inhoud;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public Product(String name, double inhoud) {
        this.name = name;
        this.inhoud = inhoud;
    }
}
