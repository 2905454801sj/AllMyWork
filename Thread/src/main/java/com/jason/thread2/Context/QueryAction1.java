package com.jason.thread2.Context;

public class QueryAction1 {
    public void execute() throws InterruptedException {
        Context context=ActionContext.getActionContext().getContext();
        String name= context.getName();
        String id=getID(name);
        context.setID(id);
    }
    private String getID(String name) throws InterruptedException {
        Thread.sleep(1000);
        return "11111111111111111111"+Thread.currentThread().getId();
    }
}
