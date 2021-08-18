package com.jason.thread2.Immutable;

import java.util.Optional;

public class PersonThread extends Thread{
    private Person person;

    public PersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while(true){
            Optional.of(Thread.currentThread().getName()+":"+person.toString()).ifPresent(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
