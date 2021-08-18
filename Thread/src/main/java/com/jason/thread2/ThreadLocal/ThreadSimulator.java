package com.jason.thread2.ThreadLocal;


import java.util.HashMap;
import java.util.Map;

public class ThreadSimulator<T> {
    private final Map<Thread,T> storage=new HashMap<>();
    public void set(T t){
        synchronized (ThreadSimulator.class){
            Thread key = Thread.currentThread();
            storage.put(key,t);

        }
    }
    public T get(){
        synchronized (ThreadSimulator.class){
            Thread key = Thread.currentThread();
            return storage.get(key);
        }
    }
}
