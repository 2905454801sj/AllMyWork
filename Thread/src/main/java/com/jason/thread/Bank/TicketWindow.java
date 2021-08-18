package com.jason.thread.Bank;

public class TicketWindow extends Thread{
    private static final int MAX=50;
    private final String name;
    private static int index=1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(index<=MAX){
            System.out.println("柜台"+name+"->当前号码："+(index++));
        }
    }
}
