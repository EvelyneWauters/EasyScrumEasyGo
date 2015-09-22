package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.PassengerAddress;
import com.realdolmen.passenger.domain.PassengerType;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class PassengerStatefulBean implements PassengerStatefulBeanInterface{

    private Passenger passenger;

    @PersistenceContext
    EntityManager entityManager;

    public void createPassenger(String firstName, String lastName)   {
        passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        String ssn = (firstName + " " + lastName).hashCode() + "";
        passenger.setSsn(ssn);
        passenger.setFrequentFlyerMiles(0);
        entityManager.persist(passenger);
        passenger.setId(entityManager.createQuery("select p from Passenger p where p.ssn = " + ssn, Passenger.class).getSingleResult().getId());
    }

    public void addPassengerType (PassengerType passengerType)  {
        passenger.setPassengerType(passengerType);
        entityManager.merge(passenger);
        entityManager.persist(passenger);
    }


    public void addAddress(String street, String city)  {
        PassengerAddress address = new PassengerAddress(street, city);
        passenger.setAddress(address);
        //Passenger p  = entityManager.find(Passenger.class, passenger.getId());
        //Passenger referencePassenger = entityManager.getReference(Passenger.class, passenger.getId());
        entityManager.merge(passenger);
        entityManager.persist(passenger);
    }

    public void addCreditCard(String creditCardNumber)  {

    }

    public void assignTicketToPassenger()   {
    }


    @Remove
    public void checkout()  {
        passenger = new Passenger();
    }



}
