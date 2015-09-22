package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean
public class TicketStatelessBean implements TicketStatelessBeanInterface, Serializable {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Ticket> findAllTickets() {
        return entityManager.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }

    @Override
    public Ticket findById(int id)    {
        return entityManager.find(Ticket.class, id);
    }


    @Override
    public void createTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }



    @Override
    public void updateTicket(Ticket ticket) {
        entityManager.find(Passenger.class, ticket.getId());
        entityManager.persist(ticket);
    }

    @Override
    public List<Ticket> findTicketByPassengerId(int pid) {
        //return entityManager.createQuery("select t from Ticket t where p.id= :pid", Ticket.class).getResultList();
        return entityManager.createQuery("SELECT t FROM Passenger p join p.ticketList t where p.id = :pid", Ticket.class).setParameter("pid", pid).getResultList();

        //de juiste SQL query is:
        //SELECT * FROM test.ticket tt
        //join passenger_ticket pt on tt.id= pt.ticketList_id
        //where pt.passenger_id = 500;

    }

    @Override
    public void bookTicketForPassenger(int pid, Ticket ticket) {
        createTicket(ticket);
        Passenger passenger = entityManager.find(Passenger.class, pid);
        passenger.addTicket(ticket);
        entityManager.persist(passenger);
    }


}
