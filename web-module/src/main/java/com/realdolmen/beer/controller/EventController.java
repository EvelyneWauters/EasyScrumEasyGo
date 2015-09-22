package com.realdolmen.beer.controller;

import com.realdolmen.beer.domain.Evenement;
import com.realdolmen.beer.domain.Product;
import com.realdolmen.beer.domain.Verkoop;
import com.realdolmen.beer.persistence.VerkoopEJB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class EventController {

    @Inject
    private VerkoopEJB verkoopEJB ;


    public List<Evenement> getEvents() {
        //findallevents
        //return verkoopEJB
        return new ArrayList<>();
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        verkoopEJB.getAlleVerkoop().forEach((item) -> products.add(item.getProduct()));
        return products;
    }

    public void addQuantity(Product product){
        verkoopEJB.addQuantity(1,new Verkoop(product,1));
    }

    public double getQuantity(Product product) {
        double quantity = 0;

        for(Verkoop verkoop : verkoopEJB.getAlleVerkoop()){
            if(product.getId() == verkoop.getProduct().getId()) {
                quantity += verkoop.getAantal();
            }
        }

        return quantity;
    }
}
