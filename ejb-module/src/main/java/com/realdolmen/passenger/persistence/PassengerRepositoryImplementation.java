package com.realdolmen.passenger.persistence;

import com.realdolmen.course.domain.Book;
import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Stateless
@LocalBean
public class PassengerRepositoryImplementation implements PassengerRepository, Serializable {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Passenger> findAll() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    @Override
    public void savePassenger(Passenger p) {
        entityManager.persist(p);
    }


    @Override
    public Passenger findById(int id)    {
        return entityManager.find(Passenger.class, id);
    }



    @Override
    public void updatePassenger(Passenger passenger) {
        entityManager.find(Passenger.class, passenger.getId());
        entityManager.persist(passenger);
    }

    @Override
    public void deletePassengerById(int id) {
        Passenger p = entityManager.getReference(Passenger.class, id);
        entityManager.remove(p);
    }

    @Override
    public List<String> findAllLastNames() {
        return entityManager.createQuery("select p.lastName from Passenger p").getResultList();
    }

    @Override
    public int getTotalFrequentFlyerMiles() {
        List frequentFlyerMilesList = entityManager.createQuery("select p.frequentFlyerMiles from Passenger p").getResultList();
        int totalFrequentFlyerMiles = 0;

        //gaat natuurlijk nog beter met een SUM-query

        for (Object miles : frequentFlyerMilesList) {
            int i = (Integer) miles;
            totalFrequentFlyerMiles = totalFrequentFlyerMiles + i;
        }
        return totalFrequentFlyerMiles;
    }


    @Override
    public void deleteAllPassengers() {
        //bulk delete:
        entityManager.createQuery("delete from Ticket t").executeUpdate();
        entityManager.createQuery("delete from Passenger p").executeUpdate();
    }

    @Override
    public List<Passenger> findPassengerByName(String str) {
        return entityManager.createQuery("select p from Passenger p where p.firstName like :str OR p.lastName like :str", Passenger.class).setParameter("str", "%str%").getResultList();

    }


}















