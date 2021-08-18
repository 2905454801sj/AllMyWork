package com.jason.thread2.Observer;

import java.util.Optional;

public abstract class ObserverClient {
    public static void main(String[] args) {
        final Subject subject=new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        Optional.of("=============================").ifPresent(System.out::println);
        subject.setState(10);
        Optional.of("=============================").ifPresent(System.out::println);
        subject.setState(10);
        Optional.of("=============================").ifPresent(System.out::println);
        subject.setState(15);
    }
}
