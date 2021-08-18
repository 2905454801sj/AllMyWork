package com.jason.thread.Thread;

public class ThreadCloseForce {

    public static void main(String[] args) throws InterruptedException {
        ThreadService threadService=new ThreadService();
        long start=System.currentTimeMillis();
        threadService.exe(()->{
            while(true){

            }
        });
        threadService.shutdown(10000);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

}
