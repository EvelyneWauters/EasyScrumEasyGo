package com.realdolmen.beer.persistence;

import com.realdolmen.beer.domain.Verkoop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
