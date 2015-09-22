package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Passenger;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface PassengerStatefulBeanInterface {

    public void createPassenger(String firstName, String lastName)  ;

    public void addAddress(String street, String city);

    public void addCreditCard(String creditCardNumber);

    public void assignTicketToPassenger();

    public void checkout()  ;




}
