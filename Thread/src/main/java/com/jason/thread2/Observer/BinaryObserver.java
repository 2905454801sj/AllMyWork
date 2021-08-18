package com.jason.thread2.Observer;

import java.util.Optional;

public class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        Optional.of("Octal String:"+Integer.toOctalString(subject.getState())).ifPresent(System.out::println);
    }
}
