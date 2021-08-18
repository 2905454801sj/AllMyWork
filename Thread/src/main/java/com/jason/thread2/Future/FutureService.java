package com.jason.thread2.Future;

import java.util.function.Consumer;

public class FutureService<T> {
    public <T> Future<T> submit(final FutureTask<T> task){
        AsynFuture<T> asynFuture=new AsynFuture<>();
        new Thread(()->{
            T result = null;
            try {
                result = task.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
    public <T> Future<T> submit(final FutureTask<T> task,final Consumer<T> consumer){
        AsynFuture<T> asynFuture=new AsynFuture<>();
        new Thread(()->{
            T result = null;
            try {
                result = task.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
