package com.jason.thread2.SingleThread;

public class Client {
    public static void main(String[] args) {
        Gate gate=new Gate();
        Visitor v1=new Visitor("A","AA",gate);
        Visitor v2=new Visitor("B","BB",gate);
        Visitor v3=new Visitor("C","CC",gate);

        v1.start();
        v2.start();
        v3.start();

    }
}
