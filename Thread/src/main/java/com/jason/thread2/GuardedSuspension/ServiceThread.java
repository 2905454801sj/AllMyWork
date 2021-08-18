package com.jason.thread2.GuardedSuspension;

public class ServiceThread extends Thread{
    private final RequestQueue queue;

    private volatile boolean flag=false;
    public ServiceThread(RequestQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            while(!flag) {
                Request request = queue.getRequest();
                if (request == null) {
                    System.out.println("receive null request.");
                    continue;
                }
                System.out.println("Server:" + request.getValue());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
    }

    public void close(){
        this.flag = true;
        this.interrupt();
    }
}
