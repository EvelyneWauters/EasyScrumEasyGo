package com.realdolmen.beer.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Evenement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    private List<Verkoop> verkoopList;

    public int getId() {
        return id;
    }

    public Evenement() {
    }

    public Evenement(List<Verkoop> verkoopList) {
        this.verkoopList = verkoopList;
    }

    public void addVerkoop(Verkoop verkoop){
        verkoopList.add(verkoop);
    }

    public List<Verkoop> getVerkoopList() {
        return verkoopList;
    }

    public void setVerkoopList(List<Verkoop> verkoopList) {
        this.verkoopList = verkoopList;
    }

    public String getName() {
        return name;
    }
}
