package com.jason.thread2.GuardedSuspension;

import java.util.Random;

public class ClientThread extends Thread{
    private final RequestQueue queue;
    private final Random random;
    private final String sendValue;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.sendValue = sendValue;
        random=new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Request:"+sendValue);
            queue.putRequest(new Request(sendValue));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
