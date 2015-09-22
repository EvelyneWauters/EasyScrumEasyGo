package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

 @Remote
public interface TicketStatelessBeanInterface {

    public List<Ticket> findAllTickets();

    public Ticket findById(int id);

    public void createTicket(Ticket ticket);

    public void updateTicket(Ticket ticket);

     List<Ticket> findTicketByPassengerId(int i);

     public void bookTicketForPassenger(int pid, Ticket ticket);

 }
