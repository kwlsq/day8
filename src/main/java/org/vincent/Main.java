package org.vincent;

import org.vincent.entity.Event;
import org.vincent.entity.Ticket;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ticket Booking System!");

        // Store events in a map
        Map<Integer, Event> eventMap = new HashMap<>();
        eventMap.put(1, new Event(1, "O I I A Cat", 1, 10000));
        eventMap.put(2, new Event(2, "Snoop Dogg", 5, 20000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nList of Concerts:");
            for (Map.Entry<Integer, Event> entry : eventMap.entrySet()) {
                Event event = entry.getValue();
                event.printAvailableTickets();
            }

            System.out.println("\nEnter the event number to book a ticket, or type 'exit' to quit:");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Ticket Booking System. Goodbye!");
                break;
            }

            try {
                int selectedEvent = Integer.parseInt(input);

                if (!eventMap.containsKey(selectedEvent)) {
                    System.out.println("Invalid event selection. Please try again.");
                    continue;
                }

                Event chosenEvent = eventMap.get(selectedEvent);
                UUID ticketID = chosenEvent.getAndMarkOneAvailableTicket();
                if(ticketID == null){
                    System.out.println("No available ticket. Please select other event.");
                    continue;
                }

                System.out.print("Enter your name: ");
                String userName = scanner.next();
                chosenEvent.setSpecificTicketOwnerName(ticketID,userName);

                Booking newBooking = new Booking(ticketID, userName);
                System.out.println("Ticket booked successfully! Ticket ID: " + ticketID);

                // Ask for payment confirmation
                System.out.println("Do you want to confirm the payment? (yes/no)");
                String confirm = scanner.next();
                if (confirm.equalsIgnoreCase("yes")) {
                    newBooking.confirmPayment();
                } else {
                    System.out.println("Payment not confirmed yet. You can confirm later.");
                }

                newBooking.printBookingDetails();

                // Ask if they want to book another ticket
                System.out.println("\nDo you want to book another ticket? (yes/exit)");
                String continueBooking = scanner.next();
                if (continueBooking.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using the Ticket Booking System. Goodbye!");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid event number.");
            }
        }

        scanner.close();
    }
}