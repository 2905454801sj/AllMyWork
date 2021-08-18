package com.jason.thread2.Context;

import java.util.Optional;

public class ExecutionTask implements Runnable{
    private QueryAction queryAction=new QueryAction();
    private QueryAction1 queryAction1=new QueryAction1();
    @Override
    public void run() {
        Context context=ActionContext.getActionContext().getContext();
        try {
            queryAction.execute();
            Optional.of("the name query seccessful").ifPresent(System.out::println);
            queryAction1.execute();
            Optional.of("the id query seccessful").ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of("the name is " +context.getName()+" and id"+context.getId()).ifPresent(System.out::println);
    }
}
