package com.jason.thread2.Singleton;

public class SingletonObject6 {
    //解决懒加载，性能问题和控制异常
    private SingletonObject6(){

    }
    private static class InstanceHolder{
        //static只会在最初被加载一次
        private final static SingletonObject6 instance=new SingletonObject6();
    }
    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
