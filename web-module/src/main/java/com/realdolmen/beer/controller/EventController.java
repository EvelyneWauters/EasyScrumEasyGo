package com.realdolmen.beer.controller;

import com.realdolmen.beer.domain.Evenement;
import com.realdolmen.beer.domain.Product;
import com.realdolmen.beer.domain.Verkoop;
import com.realdolmen.beer.persistence.VerkoopEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class EventController implements Serializable {

    @EJB
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

    public void addQuantityKleinPintje(Product product){
        Verkoop verkoop = verkoopEJB.getAlleVerkoop().stream().filter(v -> v.getProduct().getId() == product.getId()).findFirst().get();
        verkoopEJB.addPintjeAanHoeveelheid(verkoop.getId());
    }

    public void addQuantityGrootPintje(Product product){
        Verkoop verkoop = verkoopEJB.getAlleVerkoop().stream().filter(v -> v.getProduct().getId() == product.getId()).findFirst().get();
        System.out.println(verkoop.getId());
        verkoopEJB.addGrootPintjeAanHoeveelheid(verkoop.getId());
    }

    public void addQuantityVat(Product product){
        Verkoop verkoop = verkoopEJB.getAlleVerkoop().stream().filter(v -> v.getProduct().getId() == product.getId()).findFirst().get();
        System.out.println(verkoop.getId());
        verkoopEJB.addVatAanHoeveelheid(verkoop.getId());
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
