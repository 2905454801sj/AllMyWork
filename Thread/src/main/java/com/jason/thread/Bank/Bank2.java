package com.jason.thread.Bank;

public class Bank2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable=new TicketWindowRunnable();
        Thread window1=new Thread(ticketWindowRunnable,"A");
        Thread window2=new Thread(ticketWindowRunnable,"B");
        Thread window3=new Thread(ticketWindowRunnable,"C");
        window1.start();
        window2.start();
        window3.start();
    }
}
