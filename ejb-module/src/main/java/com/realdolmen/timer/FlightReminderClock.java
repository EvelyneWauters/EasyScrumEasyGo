package com.realdolmen.timer;


import com.realdolmen.passenger.domain.Flight;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Singleton
public class FlightReminderClock {

    @Resource
    TimerService timerService;

    @PersistenceContext
    private EntityManager entityManager;


    public void createFlight(Flight flight)  {
        entityManager.persist(flight);
        // LocalDate localDate = Instant.ofEpochMilli(flight.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        //convert to LocalDateTime
        Instant instant = Instant.ofEpochMilli(flight.getDate().getTime());
        LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        ScheduleExpression remindDate = new ScheduleExpression().
                dayOfMonth(time.getDayOfMonth()).
                month(time.getMonthValue()).
                hour(time.getHour()).
                minute(time.getMinute()).
                second(time.getSecond());

        timerService.createCalendarTimer(remindDate, new TimerConfig(flight, false));
    }


    @Timeout
    public void sendReminder(Timer timer)  {
        System.out.println("YOUR FLIGHT LEAVES SOON");
    }


}
