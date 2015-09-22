package com.realdolmen.passenger.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by EWTAX45 on 11/09/2015.
 */

@Entity
public class Ticket implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private int price;

    @ManyToOne
    private Flight flight;

    public Ticket() {
    }

    public Ticket(int price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
