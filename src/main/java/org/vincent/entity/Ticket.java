package org.vincent.entity;

import java.util.UUID;

public class Ticket {
    private final String eventName;
    private double price;
    private boolean isAvailable;
    private String ticketOwnerName;


    public Ticket(UUID ID, String eventName, double price) {
        this.eventName = eventName;
        this.price = price;
        this.isAvailable = true;
        this.ticketOwnerName = "";
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void setTicketOwnerName(String userName) {
        this.ticketOwnerName = userName;
    }

    public void printDetails (int totalAvailableTickets, int eventID){
        System.out.println(eventID + ". " + this.eventName + " has " + totalAvailableTickets + " available tickets");
        System.out.println("Ticket price: " + this.price);
    }

}
