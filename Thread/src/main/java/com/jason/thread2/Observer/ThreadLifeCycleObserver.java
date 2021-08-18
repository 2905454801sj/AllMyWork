package com.jason.thread2.Observer;

import java.util.List;
import java.util.Optional;

public class ThreadLifeCycleObserver implements LifeCycleListener{
    private final Object LOCK=new Object();
    public void concurrentQuery(List<Integer> ids){
        if(ids==null||ids.isEmpty()){
            return;
        }
        ids.stream().forEach(id->new Thread(new ObserverRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    Optional.of("Query for the id "+id).ifPresent(System.out::println);
                    Thread.sleep(1000);
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                } catch (InterruptedException e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        }, String.valueOf(id)).start());
    }
    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        synchronized (LOCK){
            Optional.of("The runnable "+event.getThread().getName()+" data changed and the state is "+event.getState())
                    .ifPresent(System.out::println);
            if(event.getCause()!=null){
                Optional.of("The runnable "+event.getThread().getName()+" error")
                        .ifPresent(System.out::println);
                event.getCause().printStackTrace();
            }
        }
    }
}
