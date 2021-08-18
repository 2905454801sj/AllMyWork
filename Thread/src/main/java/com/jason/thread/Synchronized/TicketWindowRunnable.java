package com.jason.thread.Synchronized;

public class TicketWindowRunnable implements Runnable{
    private int index=1;
    private final static int MAX=500;
    private Object Monitor=new Object();
    @Override
    public void run() {
        synchronized (Monitor) {
            while (true) {
                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "号码：" + (index++));
            }
        }
    }
}
