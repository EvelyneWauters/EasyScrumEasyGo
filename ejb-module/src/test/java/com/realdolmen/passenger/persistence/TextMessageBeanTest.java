package com.realdolmen.passenger.persistence;

import com.realdolmen.course.integration.RemoteJmsTest;
import org.junit.Test;

import javax.jms.TextMessage;



public class TextMessageBeanTest extends RemoteJmsTest {

    // een Unit test schrijven waarbij een assert wordt getest, is niet vanzelfsprekend omdat MOM een
    // asynchrone architectuur is, dus het is mogelijk dat de message nog niet verzonden/ontvangen is

    @Test
    public void producteTextMessage() throws Exception  {
        System.out.println("sending message from backend");
        TextMessage message = session.createTextMessage("199.95,200,1000/n1000,250");
        producer.send(message);
    }
}
