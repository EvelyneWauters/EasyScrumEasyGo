package com.realdolmen.passenger.domain;

import javax.persistence.Embeddable;

/**
 * Created by EWTAX45 on 14/09/2015.
 */

@Embeddable
public class PassengerAddress {

    private String street;
    private String city;

    public PassengerAddress() {
    }

    public PassengerAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
