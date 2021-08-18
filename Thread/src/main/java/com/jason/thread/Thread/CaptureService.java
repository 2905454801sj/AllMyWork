package com.jason.thread.Thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
//限制多线程一次只能运行五个
public class CaptureService {
    private static class control{

    }
    final static private LinkedList<control> control=new LinkedList<>();
    public static Thread createCaptureThread(String name){
        return new Thread(()->{
            Optional.of("The worker ["+Thread.currentThread().getName()+"] begin capture data").
                    ifPresent(System.out::println);
            synchronized (control){
                while(control.size()>=5){
                    try {
                        control.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                control.addLast(new control());
            }
            Optional.of("The worker ["+Thread.currentThread().getName()+"] is running").
                    ifPresent(System.out::println);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (control){
                Optional.of("The worker ["+Thread.currentThread().getName()+"] end").
                        ifPresent(System.out::println);
                control.removeFirst();
                control.notifyAll();
            }
        },name);
    }
    public static void main(String[] args) {
        List<Thread> worker=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("m"+i);
        }
        list.stream().map(CaptureService::createCaptureThread).forEach(t->{
            t.start();
            worker.add(t);
        });
        worker.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("all worker is done").ifPresent(System.out::println);
    }
}
