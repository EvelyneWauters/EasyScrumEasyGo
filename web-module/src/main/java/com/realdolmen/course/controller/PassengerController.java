package com.realdolmen.course.controller;

import com.realdolmen.course.persistence.BookRepository;
import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.Ticket;
import com.realdolmen.passenger.persistence.PassengerRepositoryImplementation;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by EWTAX45 on 15/09/2015.
 */

@Named
@ConversationScoped
public class PassengerController implements Serializable {

    @Inject
    PassengerRepositoryImplementation repository;

    Passenger passenger = new Passenger();

    public List<Passenger> findAllPassengers()  {
        return repository.findAll();
    }

    public void createPassenger()   {
        repository.savePassenger(passenger);
    }

    public String createPassengerAndGoToPassengerList()   {
        repository.savePassenger(passenger);
        return "passengerlist";
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void removePassenger(int pid)    {
        repository.deletePassengerById(pid);
    }
}
