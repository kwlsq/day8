package org.vincent;

import org.vincent.entity.Event;

public class Main {
    public static void main(String[] args) {

        Event newEvent = new Event("Test", 10, 10000);

        newEvent.printAvailableTickets();

    }
}