package com.jason.thread.ProductorConsumer;

public class ProductorConsumer1 {
    private int i=1;
    final private Object MON=new Object();
    private void produce(){
        synchronized (MON){
            while(true){
                try {
                    Thread.sleep(500);
                    System.out.println("已生产数据："+(i++));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void consume(){
        synchronized (MON){
            while(true) {
                try {
                    Thread.sleep(500);
                    System.out.println("已消费数据：" + (i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductorConsumer1 productorConsumer1=new ProductorConsumer1();
        new Thread("P"){
            @Override
            public void run() {
                productorConsumer1.produce();
            }
        }.start();
        new Thread("C"){
            @Override
            public void run() {
                productorConsumer1.consume();
            }
        }.start();
    }
}
