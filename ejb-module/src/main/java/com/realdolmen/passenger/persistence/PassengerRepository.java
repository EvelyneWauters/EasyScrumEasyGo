package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PassengerRepository {

    public List<Passenger> findAll();

    public void savePassenger(Passenger p);

    public Passenger findById(int id);

    public void updatePassenger(Passenger passenger);

    public void deletePassengerById(int id);

    List<String> findAllLastNames();

    int getTotalFrequentFlyerMiles();

    void deleteAllPassengers();

    public List<Passenger> findPassengerByName(String string);

}
