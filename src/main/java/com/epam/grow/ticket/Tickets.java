package com.epam.grow.ticket;

public class Tickets {
    private int ticketsCount;

    public Tickets(int tickets) {
        ticketsCount = tickets;
        System.out.println("Hello we have " + this.ticketsCount + " tickets available");
    }

    public  void makeReservation(int qty){
        if (ticketsCount > 0){
            System.out.println("Ticket reserved");
            decrease(qty);
        } else {
            System.out.println("Sry we are out of tickets");
        }
    }

    private synchronized void decrease(int qty) {
        ticketsCount-=qty;
    }


}
