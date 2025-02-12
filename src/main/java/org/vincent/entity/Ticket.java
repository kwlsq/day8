package org.vincent.entity;

import java.util.UUID;

public class Ticket {
    private final UUID ID;
    private final String eventName;
    private double price;
    private boolean isAvailable;
    private String ticketOwnerID;


    public Ticket(String ID, String eventName, double price) {
        this.ID = UUID.randomUUID();
        this.eventName = eventName;
        this.price = price;
        this.isAvailable = true;
        this.ticketOwnerID = null;
    }



}
