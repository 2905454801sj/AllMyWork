package com.jason.thread2.GuardedSuspension;

public class SuspendsionClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue requestQueue=new RequestQueue();
        new ClientThread(requestQueue,"Jason").start();
        ServiceThread serviceThread = new ServiceThread(requestQueue);
        serviceThread.start();
        Thread.sleep(1000);

        serviceThread.close();
    }
}
