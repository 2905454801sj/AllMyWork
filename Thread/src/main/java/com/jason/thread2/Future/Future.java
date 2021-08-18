package com.jason.thread2.Future;

public interface Future<T>{
    T get() throws InterruptedException;
}
