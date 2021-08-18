package com.jason.thread2.WriteReadLock;

public class Client {
    public static void main(String[] args) {
        final SharedData sharedData=new SharedData(10);
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new WriteWoker(sharedData,"abcdefghijklmn").start();
        new WriteWoker(sharedData,"ABCDEFGHIJKLMN").start();
    }
}
