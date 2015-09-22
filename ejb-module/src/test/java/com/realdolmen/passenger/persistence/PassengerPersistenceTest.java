package com.realdolmen.passenger.persistence;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.course.persistence.PersistenceTest;
import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.PassengerType;
import com.realdolmen.passenger.domain.Ticket;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class PassengerPersistenceTest extends DataSetPersistenceTest {

    PassengerRepositoryImplementation passengerRepository;

    TicketStatelessBean ticketRepository;

    @Before
    public void initializeRepository() {
        passengerRepository = new PassengerRepositoryImplementation();
        ticketRepository = new TicketStatelessBean();
        ticketRepository.entityManager = entityManager();
        passengerRepository.entityManager = entityManager();
    }



    @Test
    public void returnAllPassengers() throws Exception  {
        assertNotNull(passengerRepository.findAll());
    }


    @Test
    public void savePassenger() throws Exception    {
        Passenger passenger = new Passenger("Noor", "Anthonis");
        passenger.setSsn("1565456");
        passenger.setFrequentFlyerMiles(80);
        passengerRepository.savePassenger(passenger);
        entityManager().flush();
        String firstName = entityManager().createQuery("select p from Passenger p where p.ssn='1565456'", Passenger.class).getSingleResult().getFirstName();
        assertEquals("Noor", firstName);
    }


    @Test
    public void findPassengerById() throws Exception    {
        Passenger passenger = passengerRepository.findById(500);
        assertEquals("Lars", passenger.getFirstName() );
    }


    @Test
    public void findAllLastNamesTest() throws Exception {
        List<String> passengerLastNames = passengerRepository.findAllLastNames();
        assertTrue(passengerLastNames.contains("De Pauw"));
    }

    @Test
    public void returntotalFrequentFlyerMiles() throws Exception    {
        int totalFrequentFlyerMiles = passengerRepository.getTotalFrequentFlyerMiles();
        assertEquals(160, totalFrequentFlyerMiles);
    }


    @Test
    public void testThatAPassengerCanBeRemovedByIt()    throws Exception    {
        passengerRepository.deletePassengerById(500);
        assertNull(passengerRepository.findById(500));
    }
    
    @Test
    public void testThatAPassengerCanBeRemovedButTicketsStillExist()    throws Exception    {
        Passenger p = passengerRepository.findById(500);
        passengerRepository.deletePassengerById(500);
        assertNotNull(ticketRepository.findById(p.getTicketList().get(0).getId()));
    }




    @Ignore
    @Test
    public void deleteAllPassengersTest() throws Exception  {
        passengerRepository.deleteAllPassengers();
        assertEquals(0, passengerRepository.findAll().size());
    }


    @Test
    public void testThatAPassengerCanBeFound()  throws Exception    {
        assertNotNull(passengerRepository.findPassengerByName("a"));
    }

//    @Test
//    public void assignTicketToPassengerById() throws Exception  {
//        Ticket ticket = new Ticket(333);
//        Passenger lars = passengerRepository.findById(500);
//        lars.addTicket(ticket);
//        passengerRepository.updatePassenger(lars);
//        assertEquals(333, passengerRepository.findById(500).getTicket().get(0).getPrice());
//    }
//
//    @Test
//    public void findTicketsByPassngerId() throws Exception  {
//        Ticket ticket = passengerRepository.findTicketByPassengerId(500);
//        assertEquals(789, ticket.getPrice());
//    }


//    @Test
//    public void checkThatVersionAddsWithConcurrency() throws Exception  {
//        Passenger p1 = passengerRepository.findById(600);
//        p1.setLastName("This is a test");
//        passengerRepository.updatePassenger(p1);
//
//        Passenger p2 = passengerRepository.findById(600);
//        p2.setLastName("which one is it going to be?");
//        passengerRepository.updatePassenger(p2);
//
//        //todo: implement threading in this test
//
//        fail();
//    }

//    @Test
//    public void testAgeIsCalculatedRight() throws Exception {
//        Passenger passenger = entityManager().createQuery("select p from Passenger p where id=123", Passenger.class).getSingleResult();
//        assertEquals(713, passenger.getAge());
//    }

}
