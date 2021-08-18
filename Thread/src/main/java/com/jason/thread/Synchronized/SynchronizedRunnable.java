package com.jason.thread.Synchronized;

public class SynchronizedRunnable implements Runnable{
    private int index=1;
    private final static int MAX=500;
    private Object Monitor=new Object();
    @Override
    public void run() {
            while (true) {
                if (ticket()) {
                    break;
                }
            }
    }
    public synchronized boolean ticket(){
        if (index > MAX) {
            return true;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "号码：" + (index++));
        return false;
    }
}
