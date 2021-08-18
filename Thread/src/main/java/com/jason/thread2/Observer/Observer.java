package com.jason.thread2.Observer;

public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
