package com.jason.thread.ProductorConsumer;

import java.util.stream.Stream;

public class ProductorConsumer4 {
    private int i=1;
    final private Object MON=new Object();
    private volatile boolean ispro=false;
    private void produce() throws InterruptedException {
        synchronized (MON){
            while(ispro){
                MON.wait();
            }
            Thread.sleep(500);
            System.out.println("已生产数据："+(i++));
            MON.notifyAll();
            ispro=true;
        }
    }
    private void consume() throws InterruptedException {
        synchronized (MON){
            while(!ispro){
                MON.wait();
            }
            System.out.println("已消费数据："+(i-1));
            MON.notifyAll();
            ispro=false;
        }
    }

    public static void main(String[] args) {
        ProductorConsumer4 productorConsumer1=new ProductorConsumer4();
        Stream.of("P1","p2","P3").forEach(n->
                new Thread(n){
                @Override
                public void run() {
                    try {
                        while(true) {
                            productorConsumer1.produce();
                            Thread.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start());
        Stream.of("C1","C2","C3","C4").forEach(n->
                new Thread(n){
            @Override
            public void run() {
                try {
                    while(true) {
                        productorConsumer1.consume();
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start());
        ;
    }
}
