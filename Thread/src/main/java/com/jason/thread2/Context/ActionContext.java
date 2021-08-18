package com.jason.thread2.Context;

public final class ActionContext {

    private static final ThreadLocal<Context> threadlocal=new ThreadLocal<>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder{
        private final static ActionContext actionContext=new ActionContext();
    }

    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }

     public Context getContext(){
         return threadlocal.get();
     }
}
