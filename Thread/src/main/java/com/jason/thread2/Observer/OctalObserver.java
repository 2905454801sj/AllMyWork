package com.jason.thread2.Observer;

import java.util.Optional;

public class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        Optional.of("Binary String:"+Integer.toBinaryString(subject.getState())).ifPresent(System.out::println);
    }
}
