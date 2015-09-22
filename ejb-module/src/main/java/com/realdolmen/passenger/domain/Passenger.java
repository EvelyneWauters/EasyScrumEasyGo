package com.realdolmen.passenger.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.*;

@Entity
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, updatable = false)
    private String ssn;

    @Column (length = 50)
    private String firstName;

    @Column (length = 50)
    private String lastName;

    @Temporal (TemporalType.TIME)
    private Date birthdate;

    @Transient
    private int age;

    @Enumerated (EnumType.STRING)
    private PassengerType passengerType;

    @Column
    private int frequentFlyerMiles;

    @OneToMany
    private List<Ticket> ticketList = new ArrayList<>();

    @Embedded
    private PassengerAddress address;


    public Passenger() {
    }

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public List<Ticket> getTicket() {
        return ticketList;
    }

    public void addTicket(Ticket t) {
        this.ticketList.add(t);
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticketList = ticket;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        this.setAge();
    }

    private void setAge() {
        Date date = new Date();

        //LocalDateTime now = LocalDateTime.now();     // The current date and time
        //LocalDate.of(2012, Month.DECEMBER, 12); // from values

        //LocalTime.of(17, 18); // the train I took home today
        //LocalTime.parse("10:15:30"); // From a String

        //date.se
        //this.age = LocalDateTime.now().getYear() - ;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }


    public PassengerAddress getAddress() {
        return address;
    }

    public void setAddress(PassengerAddress address) {
        this.address = address;
    }


}
