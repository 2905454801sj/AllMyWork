package com.jason.thread.ThreadPool;

import javax.naming.TimeLimitExceededException;
import java.util.*;

public class SimpleThreadPool extends Thread{
    public static class DiscardException extends TimeLimitExceededException{
        public DiscardException(String message) {
            super(message);
        }
    }
    public interface DiscardPolicy{
        void discard() throws DiscardException;
    }
    private static class WorkTask extends Thread{
        private volatile TaskState taskState=TaskState.FREE;
        public TaskState getTaskState(){
            return this.taskState;
        }

        public WorkTask(ThreadGroup threadGroup,String name){
            //调用父类Thread的构造方法
            super(threadGroup,name);
        }

        @Override
        public void run()   {
            OUTER:
            while(this.taskState!=TaskState.DEAD){
                Runnable runnable;
                synchronized (TASK_QUEUE){
                    while(TASK_QUEUE.isEmpty()) {
                        try {
                            taskState=TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable=TASK_QUEUE.removeFirst();
                }
                if(runnable!=null){
                    taskState=TaskState.RUNNING;
                    runnable.run();
                    taskState=TaskState.FREE;
                }
            }
        }

        public void close(){
            this.taskState=TaskState.DEAD;
        }
    }
    //需要运行的线程数
    private int size;
    private static volatile int seq=0;
    private final static String THREAD_PREFIX="SIMPLE_THREADPOOL_";
    private final static int TASKSIZE=2000;
    private final int tasksize;
    private final static ThreadGroup THREAD_GROUP=new ThreadGroup("POOL_GROUP");
    //正在运行线程列表
    private final static List<WorkTask> WORK_TASK_LIST=new ArrayList<>();
    //线程队列
    private final static LinkedList<Runnable> TASK_QUEUE=new LinkedList<>();
    private final DiscardPolicy discardPolicy;
    //任务拦截
    public final static DiscardPolicy DISCARD_POLICY=()->{
        throw new DiscardException("Discard this Task.");
    };
    //线程池是否摧毁
    private volatile boolean destory=false;
    //最小线程数
    private int min;
    //最大线程数
    private int max;
    //当前正在运行线程数
    private int active;
    //枚举线程可能出现的状态
    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEAD
    }
    //无参构造方法
    public SimpleThreadPool() {
        this(4,8,12,TASKSIZE,DISCARD_POLICY);
    }

    public SimpleThreadPool(int min, int active,int max,int tasksize,DiscardPolicy discardPolicy) {
        this.min=min;
        this.active=active;
        this.max=max;
        this.tasksize=tasksize;
        this.discardPolicy=discardPolicy;
        init();
    }

    private void init() {
        for(int i=0;i<this.min;i++){
            createWorkTask();
        }
        this.size=min;
        this.start();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    @Override
    public void run() {
        while(!destory){
            Optional.of("Pool---Min:"+this.min+"-Active:"+this.active+"-Max:"+this.max+"-Current:"+this.size+
                    "-TaskSize:"+TASK_QUEUE.size()).ifPresent(System.out::println);
            try {
                Thread.sleep(5000);
                //线程池自动扩充
                if(TASK_QUEUE.size()>active&&size<active){
                    for(int i=size;i<active;i++){
                        createWorkTask();
                    }
                    Optional.of("The pool incremented to active.").ifPresent(System.out::println);
                    size=active;
                }else if(TASK_QUEUE.size()>max&&size<max){
                    for(int i=size;i<max;i++){
                        createWorkTask();
                    }
                    Optional.of("The pool incremented to max.").ifPresent(System.out::println);
                    size=max;
                }
                //线程池闲时自动回收
                synchronized (WORK_TASK_LIST){
                    int releaseSize=size-active;
                    for(Iterator<WorkTask> iterator=WORK_TASK_LIST.listIterator();iterator.hasNext();){
                        if(releaseSize<0){
                            break;
                        }
                        WorkTask workTask=iterator.next();
                        workTask.close();
                        workTask.interrupt();
                        iterator.remove();
                        releaseSize--;
                    }
                    size=active;
                }
                if(TASK_QUEUE.isEmpty()&&size>active){
                    Optional.of("=============Ruduce=============").ifPresent(System.out::println);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getTasksize() {
        return tasksize;
    }

    public boolean isdestory(){
        return this.destory;
    }

    public void submit(Runnable runnable) throws DiscardException {
        if(destory){
            throw new IllegalStateException("The threadpool already destory.");
        }
        synchronized (TASK_QUEUE){
            if(TASK_QUEUE.size()>TASKSIZE){
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    public void createWorkTask(){
        WorkTask workTask=new WorkTask(THREAD_GROUP,THREAD_PREFIX+(seq++));
        workTask.start();
        WORK_TASK_LIST.add(workTask);
    }

    public void shutdown() throws InterruptedException {
        while(!TASK_QUEUE.isEmpty()){
            Thread.sleep(1000);
        }
        synchronized (WORK_TASK_LIST) {
            int initval = WORK_TASK_LIST.size();
            while (initval > 0) {
                for (WorkTask task : WORK_TASK_LIST) {
                    if (task.getTaskState() == TaskState.BLOCKED) {
                        task.interrupt();
                        task.close();
                        initval--;
                    } else {
                        Thread.sleep(1000);
                    }
                }
            }
        }
        this.destory=true;
        Optional.of("The threadpool is disposed.").ifPresent(System.out::println);
    }

    public static void main(String[] args) throws DiscardException, InterruptedException {
        SimpleThreadPool simpleThreadPool=new SimpleThreadPool();
        for(int i=0;i<40;i++){
            simpleThreadPool.submit(()->{
                Optional.of("the runnable be serviced by"+Thread.currentThread()+"start!")
                        .ifPresent(System.out::println);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Optional.of("the runnable be serviced by"+Thread.currentThread()+"finished!")
                        .ifPresent(System.out::println);
            });
        }
        Thread.sleep(20000);
        simpleThreadPool.shutdown();
        /*simpleThreadPool.submit(()->{
            Optional.of("Cannot submit").ifPresent(System.out::println);
        });*/
    }
}
