package com.realdolmen.passenger.persistence;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.passenger.domain.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;


/**
 * Created by EWTAX45 on 15/09/2015.
 */
public class TicketPersistenceTest extends DataSetPersistenceTest {

    TicketStatelessBean ticketRepository;

    @Before
    public void initializeRepository() {
        ticketRepository = new TicketStatelessBean();
        ticketRepository.entityManager = entityManager();
    }

    @Test
    public void testThatThereAreTickets()   throws Exception    {
        assertNotNull(ticketRepository.findAllTickets());
    }

    @Test
    public void testTicketCanBeUpdated() throws Exception    {
        Ticket ticket = entityManager().find(Ticket.class, 1);
        ticket.setPrice(8000);
        ticketRepository.updateTicket(ticket);
        assertEquals(8000, entityManager().find(Ticket.class, 1).getPrice());
    }


    @Test
    public void testThatATicketIsAssignedToAPassenger() throws Exception    {
        List<Ticket> ticketByPassengerId = ticketRepository.findTicketByPassengerId(500);
        assertEquals(1, ticketByPassengerId.size());
        //assertEquals(789, ticketByPassengerId.get(0).getPrice());
    }
}
