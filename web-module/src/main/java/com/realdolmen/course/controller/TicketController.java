package com.realdolmen.course.controller;

import com.realdolmen.passenger.domain.Ticket;
import com.realdolmen.passenger.persistence.TicketStatelessBean;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
public class TicketController implements Serializable {
    @Inject
    TicketStatelessBean ticketRepository;

    Ticket ticket = new Ticket();


    public void createTicket()   {
        ticketRepository.createTicket(ticket);
    }


    public List<Ticket> retrieveAllTickets()    {
        return ticketRepository.findAllTickets();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public List<Ticket> retrieveTicketsByPassengerId(int id)    {
        return ticketRepository.findTicketByPassengerId(id);
    }

    public void addTicketForPassenger(int pid) {
        ticketRepository.bookTicketForPassenger(pid, ticket);
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
