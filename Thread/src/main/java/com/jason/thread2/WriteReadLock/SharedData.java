package com.jason.thread2.WriteReadLock;

public class SharedData {
    private final char[] buffer;

    private final WriteReadLock lock=new WriteReadLock();

    public SharedData(int size) {
        this.buffer=new char[size];
        for (int i=0;i<size;i++){
            buffer[i]='*';
        }
    }

    public char[] read(){
        try{
            lock.readLock();
            return deRead();
        }finally {
            lock.readUnLock();
        }
    }


    public void write(char c){
        try {
            lock.writeLock();
            doWrite(c);
        }catch (Exception e){
            lock.wirteUnLock();
        }
    }

    private void doWrite(char c) {
        for(int i=0;i< buffer.length;i++){
            buffer[i]=c;
            slowly(1000);
        }
    }

    private char[] deRead() {
        char[] newBuffer=new char[buffer.length];
        for (int i=0;i<buffer.length;i++){
            newBuffer[i]=buffer[i];
        }
        slowly(1000);
        return newBuffer;
    }

    private void slowly(int a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
