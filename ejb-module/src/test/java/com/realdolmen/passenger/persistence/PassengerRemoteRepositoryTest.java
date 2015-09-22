package com.realdolmen.passenger.persistence;


import com.realdolmen.course.integration.RemoteBookRepositoryTest;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.passenger.domain.Passenger;
import org.junit.*;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

public class PassengerRemoteRepositoryTest extends RemoteBookRepositoryTest {
    private PassengerRepository passengerRepository;

    @Before
    public void setUpPassengerRepository() throws NamingException{
    passengerRepository = lookup(
            "ear-module-1.1/ejb-module-1.1/PassengerRepositoryImplementation!com.realdolmen.passenger.persistence.PassengerRepository");
    }

    @Test
    public void returnAllPassengers() throws Exception  {
        assertNotNull(passengerRepository.findAll());
    }

    @Test
    public void findPassengerById() throws Exception    {
        Passenger lars = passengerRepository.findById(500);
        assertEquals("Lars", lars.getFirstName());
    }


    @Test
    public void createPassengerTest() throws Exception  {
        Passenger passenger = new Passenger("Noor", "Anthonis");
        passenger.setSsn("5445454");
        passenger.setFrequentFlyerMiles(78);

        passengerRepository.savePassenger(passenger);
        assertEquals(3, passengerRepository.findAll().size());
    }


}
