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
    private Evenement evenement;


    public List<Evenement> getEvents() {
        return verkoopEJB.getAllEvents();
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        verkoopEJB.getAlleVerkoop().forEach((item) -> {
            products.add(item.getProduct());
        });
        return products;
    }

    public List<Product> getProductsByEvent(int eventId)    {
        return verkoopEJB.getListOfProductsByEventId(eventId);
    }

    public void addQuantity(Product product){
        Verkoop verkoop = verkoopEJB.getAlleVerkoop().stream().filter(v -> v.getProduct().getId() == product.getId()).findFirst().get();
        verkoopEJB.addPintjeAanHoeveelheid(verkoop.getId());
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

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Evenement getEvenement() {
        return evenement;
    }
}
