package com.jason.thread2.Context;

public class QueryAction {
    public void execute() throws InterruptedException {
        Thread.sleep(1000);
        String name="jason  "+Thread.currentThread().getName();
        ActionContext.getActionContext().getContext().setName(name);
    }

}
