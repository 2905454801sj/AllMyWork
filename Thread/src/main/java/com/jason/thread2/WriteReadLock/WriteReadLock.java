package com.jason.thread2.WriteReadLock;

public class WriteReadLock {
    //正在进行读操作线程数
    private int reading=0;
    private int waitingreading=0;
    //正在进行写操作线程数
    private int writing=0;
    private int waitingwriting=0;
    private boolean perwirter=true;

    public WriteReadLock() {
        this(true);
    }

    public WriteReadLock(boolean perwirter) {
        this.perwirter = perwirter;
    }

    public synchronized void readLock(){
        this.waitingreading++;

            try {
                //如果有线程正在写造作，则不能进行读操作
                while(writing>0||(perwirter&&waitingwriting>0)) {
                    this.wait();
                }
                this.reading++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                this.waitingreading--;
            }
    }

    public synchronized void readUnLock(){
        this.reading--;
        notifyAll();
    }

    public synchronized void writeLock(){
        this.waitingwriting++;
        try {
            while(reading>0||writing>0){
                this.wait();
            }
            this.writing++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            this.waitingwriting--;
        }
    }

    public synchronized void wirteUnLock(){
        this.writing--;
        notifyAll();
    }
}
