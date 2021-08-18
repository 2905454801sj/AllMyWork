package com.jason.thread.Synchronized;
class Thislock{
    public synchronized void l1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void l2(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SynchronizedThis {
    public static void main(String[] args) {
        Thislock thislock=new Thislock();
        new Thread("t1"){
            @Override
            public void run() {
                thislock.l1();
            }
        }.start();
        new Thread("t2"){
            @Override
            public void run() {
                thislock.l1();
            }
        }.start();

    }
}
