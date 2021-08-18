package com.jason.thread.Thread;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Stream;

public class BooleanLockImpl {
    private static void work(){
        try {
            Optional.of(Thread.currentThread().getName()+"正在工作......").ifPresent(System.out::println);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        final BooleanLock booleanLock=new BooleanLock();
        Stream.of("t1","t2","t3","t4").forEach(t->{
            new Thread(()->{
                try {
                    //booleanLock.lock();
                    booleanLock.lock(100000);
                    Optional.of(Thread.currentThread().getName()+"抢到锁").ifPresent(System.out::println);
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Lock.TimeOutException c) {
                    Optional.of(Thread.currentThread().getName()+"已超时").ifPresent(System.out::println);
                }finally {
                    booleanLock.unlock();
                }
            },t).start();
        });
    }
}
