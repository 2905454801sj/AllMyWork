package com.jason.thread.Thread;

public class ThreadClose {
    public static class Worker extends Thread{
        private volatile boolean start=false;

        @Override
        public void run() {
            while(start){

            }
        }
        public void shutdown(){
            this.start=false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker();
        worker.start();
        Thread.sleep(10000);
        worker.shutdown();
    }
}
