package com.realdolmen.beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double inhoud;




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

    public Product() {
    }

    public Product(String name, double inhoud) {
        this.name = name;
        this.inhoud = inhoud;
    }
}
