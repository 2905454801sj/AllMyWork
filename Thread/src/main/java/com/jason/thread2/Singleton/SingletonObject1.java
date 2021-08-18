package com.jason.thread2.Singleton;

public class SingletonObject1 {
    //单例模式，因为instance是static，所以SingletonObject1被创建时，instance就会被创建，若instance长时间不被使用，就会造成内存浪费
    //缺点：不能实现懒加载
    private static final SingletonObject1 instance=new SingletonObject1();

    private SingletonObject1(){

    }
    public static SingletonObject1 getInstance(){
        return instance;
    }
}
