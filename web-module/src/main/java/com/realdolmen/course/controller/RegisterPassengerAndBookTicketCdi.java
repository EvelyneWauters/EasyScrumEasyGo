package com.realdolmen.course.controller;

import com.realdolmen.passenger.domain.Ticket;
import com.realdolmen.passenger.persistence.PassengerRepository;
import com.realdolmen.passenger.persistence.TicketStatelessBean;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterPassengerAndBookTicketCdi {

    @Inject
    private Conversation conversation;

    @Inject
    PassengerController passengerController;

    @Inject
    TicketController ticketController;

    public String startConversation() {
        conversation.begin();
        return "page1start?faces-redirect:true";
    }

    public String createPassenger() {
        passengerController.createPassenger();
        return "page2bookticket";
    }

    public String addTicketForThisPassenger(int pid)   {
        ticketController.addTicketForPassenger(pid);
        return "page3toconfirmation";
    }

    public String endConversationAndGoToHomePage()  {
        conversation.end();
        return "index";
    }





}
