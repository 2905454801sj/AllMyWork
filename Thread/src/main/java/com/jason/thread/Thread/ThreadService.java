package com.jason.thread.Thread;

public class ThreadService {
    private Thread exethread;
    private boolean fin=false;
    public void exe(Runnable task){
        exethread=new Thread(){
            @Override
            public void run() {
                Thread runner=new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    fin=true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        exethread.start();
    }
    public void shutdown(long m) {
        long currenttime=System.currentTimeMillis();
        while(!fin){
            if((System.currentTimeMillis()-currenttime)>=m){
                System.out.println("超时");
                exethread.interrupt();
                break;
            }
            try {
                exethread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("线程已被打断");
                break;
            }
        }
        fin=false;
    }
}
