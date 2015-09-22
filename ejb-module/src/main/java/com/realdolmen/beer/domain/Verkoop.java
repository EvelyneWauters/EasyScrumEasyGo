package com.realdolmen.beer.domain;

import javax.persistence.*;

@Entity
public class Verkoop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Product product;

    private double aantal;

    public int getId() {
        return id;
    }

    protected Verkoop() {
    }

    public Verkoop(Product product, int aantal) {
        this.product = product;
        this.aantal = aantal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAantal() {
        return aantal;
    }

    public void setAantal(double aantal) {
        this.aantal = aantal;
    }
}
