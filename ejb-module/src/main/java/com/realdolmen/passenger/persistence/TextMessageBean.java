package com.realdolmen.passenger.persistence;

import com.realdolmen.passenger.domain.Passenger;
import com.realdolmen.passenger.domain.Ticket;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.*;
import java.util.List;


@MessageDriven (activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class TextMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdctx;

    @EJB
    TicketStatelessBean ticketBean;

    public TextMessageBean(){
    }

    public void onMessage(Message message) {
        TextMessage msg= (TextMessage) message;
        System.out.println("Message received: " + msg);

        //parsing logic
        Ticket ticket = ticketBean.findById(1);
        ticket.setPrice(12321321);
        ticketBean.updateTicket(ticket);
    }


    public void parseMessage(String msg)  {
        String[] input = msg.split("\\n");

        for (String s : input) {

        }

    }
}
