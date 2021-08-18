package com.jason.thread.Thread;

public class ThreadClose2 {
    public static class Worker extends Thread{
        @Override
        public void run() {
            while(true) {
                if(this.isInterrupted()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker();
        worker.start();
        Thread.sleep(10000);
        worker.interrupt();
    }
}
