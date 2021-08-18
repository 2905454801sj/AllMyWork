package com.jason.thread2.Future;

public interface FutureTask<T> {
    T call() throws InterruptedException;
}
