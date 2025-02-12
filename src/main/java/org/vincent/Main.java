package org.vincent;

import org.vincent.entity.Event;

public class Main {
    public static void main(String[] args) {

        Event catConcert = new Event("O I I A Cat", 10, 10000);
        Event dogConcert = new Event("Snoop Dogg", 5, 20000);

        catConcert.printAvailableTickets();
        dogConcert.printAvailableTickets();

    }
}