package com.jason.thread.Bank;

public class TicketWindowRunnable implements Runnable{
    private int index=1;
    private final static int MAX=50;

    @Override
    public void run() {
        while(index<=50){
            System.out.println(Thread.currentThread()+"号码："+(index++));
        }
    }
}
