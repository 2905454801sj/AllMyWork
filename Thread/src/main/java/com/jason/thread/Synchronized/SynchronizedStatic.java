package com.jason.thread.Synchronized;

public class SynchronizedStatic {
    static {
        synchronized (SynchronizedStatic.class){
            try {
                System.out.println("最先线程："+Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static void m1(){
        System.out.println("m1-->"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized static void m2(){
        System.out.println("m2-->"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static void m3(){
        System.out.println("m3-->"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
