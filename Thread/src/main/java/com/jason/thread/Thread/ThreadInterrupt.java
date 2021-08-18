package com.jason.thread.Thread;

public class ThreadInterrupt {
    private static final Object MON=new Object();
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(true){
                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    synchronized (MON){
                        try {
                            MON.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
