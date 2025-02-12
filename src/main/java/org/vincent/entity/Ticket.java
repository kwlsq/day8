package org.vincent.entity;

import java.util.UUID;

public class Ticket {
    private final UUID ID;
    private final String eventName;
    private double price;
    private boolean isAvailable;
    private String ticketOwnerName;


    public Ticket(UUID ID, String eventName, double price) {
        this.ID = ID;
        this.eventName = eventName;
        this.price = price;
        this.isAvailable = true;
        this.ticketOwnerName = "";
    }


    public void printDetails (){
        System.out.println(this.ID + ", " + this.isAvailable);
    }

}
