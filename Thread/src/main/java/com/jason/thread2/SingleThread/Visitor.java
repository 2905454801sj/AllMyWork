package com.jason.thread2.SingleThread;

import java.util.Optional;

public class Visitor extends Thread{
    private final String myName;
    private final String myAddress;

    private final Gate gate;
    public Visitor(String myAddress,String myName,Gate gate){
        this.myAddress=myAddress;
        this.myName=myName;
        this.gate=gate;
    }

    @Override
    public void run() {
        Optional.of("Myname:"+myName+" beginning.").ifPresent(System.out::println);
        while(true){
            this.gate.pass(myName,myAddress);
        }
    }

}
