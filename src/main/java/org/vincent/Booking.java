package org.vincent;

import java.util.UUID;

public class Booking {
    private UUID bookingID;
    private boolean isPaid;
    private UUID ticketID;
    private String userName;

    public Booking(UUID ticketID, String userName) {
        this.bookingID = UUID.randomUUID();
        this.isPaid = false;
        this.ticketID = ticketID;
        this.userName = userName;
    }

    public void confirmPayment() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("Payment confirmed for " + userName + "! Ticket ID: " + ticketID);
        } else {
            System.out.println("Payment has already been made for this ticket.");
        }
    }

    public void printBookingDetails() {
        System.out.println("Booking ID: " + bookingID);
        System.out.println("User: " + userName);
        System.out.println("Payment Status: " + (isPaid ? "Paid" : "Unpaid"));
    }
}
