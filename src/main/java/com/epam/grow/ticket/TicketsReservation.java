package com.epam.grow.ticket;

public class TicketsReservation implements Runnable {

    private String recipientName;
    private Tickets tickets;
    private int ticketQty;

    public TicketsReservation(String recipientName, Tickets tickets, int ticketQty){
        this.recipientName = recipientName;
        this.tickets = tickets;
        this.ticketQty = ticketQty;
    }

    public void run() {
        System.out.println("Welcome " + this.recipientName + ". You are about to make ticket reservation");
        tickets.makeReservation(this.ticketQty);
    }
}
