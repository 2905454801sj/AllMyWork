package com.jason.thread2.Singleton;

public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3(){

    }
    //解决多个线程访问方法不会创建多个实例，但因为synchronized对读操作也上锁，大大降低了效率
    public synchronized static SingletonObject3 getInstance(){
        if(instance==null){
            instance=new SingletonObject3();
        }
        return instance;
    }
}
