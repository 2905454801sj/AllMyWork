package com.jason.thread.Thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock{
    private boolean initvalue;
    private Collection<Thread> blockedThreadCollection=new ArrayList<>();
    private Thread currentThread;
    public BooleanLock() {
        this.initvalue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while(initvalue){
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initvalue=true;
        this.currentThread=Thread.currentThread();
    }

    /**
     * 防止线程拿到synchronized不释放，否则其他线程永远无法拿到synchronized锁
     * @param mills
     * @throws InterruptedException
     * @throws TimeOutException
     */
    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if(mills<=0){
            try {
                throw new Exception("请输入正确毫秒值");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long keep=mills;
        long endtime=System.currentTimeMillis()+mills;
        while(initvalue){
            if(keep<=0){
                    throw new TimeOutException(Thread.currentThread()+"已超时");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            keep=System.currentTimeMillis()-endtime;
        }
        this.initvalue=true;
        this.currentThread=Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread()==this.currentThread) {
            this.initvalue = false;
            Optional.of(Thread.currentThread().getName() + "已释放").ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        //将blockedThreadCollection设置为不可修改并输出
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockerSize() {
        return blockedThreadCollection.size();
    }
}
