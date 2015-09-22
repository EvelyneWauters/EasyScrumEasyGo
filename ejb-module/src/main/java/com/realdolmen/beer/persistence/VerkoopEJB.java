package com.realdolmen.beer.persistence;

import com.realdolmen.beer.domain.Evenement;
import com.realdolmen.beer.domain.Verkoop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by MDNAX30 on 22/09/2015.
 */
public class VerkoopEJB {

    @PersistenceContext
    EntityManager em;

    public void addQuantity(int hoeveelheid, Verkoop verkoop){
        verkoop.setAantal(verkoop.getAantal() + hoeveelheid);
        em.persist(verkoop);
    }

    public List<Verkoop> getAlleVerkoop(){
        return em.createQuery("select v from Verkoop v", Verkoop.class).getResultList();
    }

    public List<Evenement> getAllEvents(){
        return em.createQuery("select e from Evenement e", Evenement.class).getResultList();
    }



}
