package com.realdolmen.passenger.persistence;
import com.realdolmen.course.integration.RemoteBookRepositoryTest;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.passenger.domain.Passenger;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

public class PassengerStatefulBeanTest extends RemoteBookRepositoryTest {

    PassengerStatefulBeanInterface passengerStatefulBean;

    @Before
    public void setUpPassengerRepository() throws NamingException {
        passengerStatefulBean = lookup(
                "ear-module-1.1/ejb-module-1.1/PassengerStatefulBean!com.realdolmen.passenger.persistence.PassengerStatefulBeanInterface"
        );
    }


    @Test
    public void testPassengerCanBeCreatedAndPersisted()throws Exception   {
        passengerStatefulBean.createPassenger("Noor", "Anthonis");
        Passenger passenger = entityManager().createQuery("select p from Passenger p where p.firstName='Noor'", Passenger.class).getSingleResult();
        assertEquals("Noor", passenger.getFirstName());
    }

    @Test
    public void testAddressCanBeAddedToPassenger() throws Exception {
        passengerStatefulBean.createPassenger("Noor", "Anthonis");
        passengerStatefulBean.addAddress("Kruisstraat", "Zoutleeuw");
        Passenger passenger = entityManager().createQuery("select p from Passenger p where p.firstName='Noor'", Passenger.class).getSingleResult();
        assertNotNull( passenger.getAddress());
        //todo: fix this test!!
    }
}
