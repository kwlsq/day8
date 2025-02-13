package org.vincent.entity;

import org.vincent.exception.BookingException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Event {
    private final int eventID;
    private String eventName;
    private HashMap<UUID, Ticket> ticketsMap;

    public Event(int eventID, String eventName, int ticketQuota, double price) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.ticketsMap = generateTickets(ticketQuota, eventName, price);
    }

    private HashMap<UUID,Ticket> generateTickets(int ticketQuota, String eventName, double price) {
        if (ticketQuota < 1) {
            throw new IllegalArgumentException("Quota must be bigger than 1");
        }
        HashMap<UUID,Ticket> generatedTickets = new HashMap<>();

        for (int i = 0; i < ticketQuota; i++) {
            UUID ticketID = UUID.randomUUID();
            generatedTickets.put(ticketID, new Ticket(ticketID,eventName,price));
        }

        return generatedTickets;
    }

    public void printAvailableTickets (){
        int totalAvailableTickets = 0;

        if(!ticketsMap.isEmpty()){
            Ticket lastTicket = null;
            for(Ticket ticket : this.ticketsMap.values()){
                if(ticket.isAvailable()){
                    totalAvailableTickets += 1;
                }
                lastTicket = ticket;
            }
            lastTicket.printDetails(totalAvailableTickets, this.eventID);
        }
    }


    public UUID getAndMarkOneAvailableTicket(String userName) {
        for (Map.Entry<UUID, Ticket> entry : ticketsMap.entrySet()) {
            Ticket ticket = entry.getValue();
            if (ticket.isAvailable()) {
                ticket.setAvailable(false);
                ticket.setTicketOwnerName(userName);
                return entry.getKey();
            }
        }
        throw new BookingException("No available tickets for this event.");
    }

    public String getEventName() {
        return this.eventName;
    }


}
