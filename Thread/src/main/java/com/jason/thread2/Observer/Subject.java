package com.jason.thread2.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList=new ArrayList<>();
    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        if(state==this.state) {
            return;
        }
        this.state=state;
        notifyAllObserver();
    }

    public void attach(Observer observer){
        observerList.add(observer);
    }

    private void notifyAllObserver(){
        observerList.stream().forEach(Observer::update);
    }
}
