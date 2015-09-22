package com.realdolmen.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import java.util.Date;

@Singleton
public class ClockEjb {

    private int count = 0;


    @Schedule (second="*", minute="*", hour="*", persistent = false)
    public void printTime(Timer timer) {
        System.out.println("*********************");
        System.out.println((new Date()));
        System.out.println("*********************");

        if(count++ == 10) {
            timer.cancel();
        }

    }

}
