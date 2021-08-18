package com.jason.thread.Thread;
class CaptureRunnable implements Runnable{
    private String name;
    private long supendTime;

    public CaptureRunnable(String name, long supendTime) {
        this.name = name;
        this.supendTime = supendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(supendTime);
            System.out.println("over  "+name+"  time:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name+" finish";
    }
}
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1=new Thread(new CaptureRunnable("a1",10000l));
        Thread t2=new Thread(new CaptureRunnable("a2",15000l));
        Thread t3=new Thread(new CaptureRunnable("a3",20000l));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end=System.currentTimeMillis();
        System.out.println("start:"+start+"  end:"+end);
    }
}
