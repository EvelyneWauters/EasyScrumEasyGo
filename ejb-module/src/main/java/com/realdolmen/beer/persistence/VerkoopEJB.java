package com.realdolmen.beer.persistence;

import com.realdolmen.beer.domain.Evenement;
import com.realdolmen.beer.domain.Product;
import com.realdolmen.beer.domain.User;
import com.realdolmen.beer.domain.Verkoop;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class VerkoopEJB {

    @PersistenceContext
    EntityManager em;

    public void addQuantity(int hoeveelheid, Verkoop verkoop) {
        verkoop.setAantal(verkoop.getAantal() + hoeveelheid);
        em.persist(verkoop);
    }

    public List<Verkoop> getAlleVerkoop() {
        return em.createQuery("select v from Verkoop v", Verkoop.class).getResultList();
    }

    public List<Evenement> getAllEvents() {
        return em.createQuery("select e from Evenement e", Evenement.class).getResultList();
    }

    public void addUser(String name, String pass) {
        User usr = new User(name, pass);
        em.persist(usr);
        em.flush();
    }


    public void addPintjeAanHoeveelheid(int verkoopId) {
        Verkoop verkoop = em.find(Verkoop.class, verkoopId);
        verkoop.setAantal(verkoop.getAantal() + 0.25);
        em.persist(verkoop);
    }

    public Evenement findEventByID(int id) {
        return em.find(Evenement.class, id);
    }

    // in: evenement_id
    // out: lijst_v_producten
    public List<Product> getListOfProductsByEventId(int id){
        ArrayList<Product> list = new ArrayList<Product>();
        Evenement e = findEventByID(id);
        for (Verkoop v : e.getVerkoopList()){
            list.add(v.getProduct());
        }
        return list;
    }

}
