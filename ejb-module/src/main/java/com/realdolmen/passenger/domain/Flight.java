package com.realdolmen.passenger.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by EWTAX45 on 14/09/2015.
 */
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String destination;
    private String origin;
    @Temporal (TemporalType.TIMESTAMP)
    private Date date;


    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
