package com.jason.thread2.Singleton;

public class SingletonObject5 {
    //volatile不能保证原子性，但能保证内存可见性
    private static volatile SingletonObject5 instance;

    private SingletonObject5(){

    }
    //解决懒加载也提高了性能
    //double check
    //会出现控制异常：第一个线程未完全初始化instance，第二个线程判断instance不为空则直接返回，
    // 其他线程则直接使用instance，就会导致控制异常
    public static SingletonObject5 getInstance(){
        if(instance==null){
            synchronized (SingletonObject5.class){
                if(instance==null){
                    instance=new SingletonObject5();
                }
            }
        }
        return instance;
    }
}
