package com.jason.thread2.WriteReadLock;

import java.util.Optional;

public class ReadWorker extends Thread{
    private final SharedData data;

    public ReadWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
            try{
                while(true) {
                    char[] readBuf = data.read();
                    Optional.of(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf))
                            .ifPresent(System.out::println);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
