package com.jason.thread.ProductorConsumer;

public class ProductorConsumer2 {
    private int i=1;
    final private Object MON=new Object();
    private volatile boolean ispro=false;
    private void produce() throws InterruptedException {
        synchronized (MON){
            if(ispro){
                    MON.wait();
            }else{
                Thread.sleep(500);
                System.out.println("已生产数据："+(i++));
                MON.notify();
                ispro=true;
            }
        }
    }
    private void consume() throws InterruptedException {
        synchronized (MON){
            if(ispro){
                System.out.println("已消费数据："+(i-1));
                MON.notify();
                ispro=false;
            }else{
                MON.wait();
                ispro=true;
            }
        }
    }

    public static void main(String[] args) {
        ProductorConsumer2 productorConsumer1=new ProductorConsumer2();
        new Thread("P"){
            @Override
            public void run() {
                try {
                    while(true) {
                        productorConsumer1.produce();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread("C"){
            @Override
            public void run() {
                try {
                    while(true) {
                        productorConsumer1.consume();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
