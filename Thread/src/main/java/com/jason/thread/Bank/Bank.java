package com.jason.thread.Bank;

public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow=new TicketWindow("1");
        ticketWindow.start();
        TicketWindow ticketWindow1=new TicketWindow("2");
        ticketWindow1.start();
        TicketWindow ticketWindow2=new TicketWindow("3");
        ticketWindow2.start();
    }
}
