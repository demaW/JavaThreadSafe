package com.epam.grow.ticket;

public class Main {
    public static void main(String[] args) {
        Tickets tickets = new Tickets(2);

        Thread t1 = new Thread(new TicketsReservation("John", tickets, 2));
        Thread t2 = new Thread(new TicketsReservation("Nick", tickets, 2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
