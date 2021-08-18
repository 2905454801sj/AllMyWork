package com.jason.thread2.SingleThread;

import java.util.Optional;
/*
共享资源
 */
public class Gate {
    private int count=0;
    private String name="nobody";
    private String address="nowhere";
    /*
    临界值引发竞争
     */
    public synchronized void pass(String name,String address){
        this.count++;
        this.name=name;
        this.address=address;
        verity();
    }

    private void verity(){
        if(this.name.charAt(0)!=this.address.charAt(0)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of("Error......"+toString()).ifPresent(System.out::println);
        }
    }

    public synchronized String toString(){
        return "No"+count+":"+name+"---address:"+address;
    }
}
