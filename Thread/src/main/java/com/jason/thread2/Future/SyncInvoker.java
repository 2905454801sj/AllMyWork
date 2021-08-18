package com.jason.thread2.Future;

import java.util.Optional;
/*
Future 代表未来的一个凭据
FutureTask 讲你的调用逻辑进行隔离
FutureService 桥接Future和FutureTask
 */
public class SyncInvoker {
    private  static String get() throws InterruptedException {
        Thread.sleep(100_000);
        return "FINISH";
    }

    public static void main(String[] args) throws InterruptedException {
        /*String result = get();
        Optional.of(result).ifPresent(System.out::println);*/
        FutureService futureService=new FutureService();
        Future<String> future=futureService.submit(()->{
            Thread.sleep(10_000);
            return "FINISH";
        }, System.out::println);
        Optional.of("=================").ifPresent(System.out::println);
        Thread.sleep(1000);
        Optional.of("do other thing......").ifPresent(System.out::println);
        Optional.of("=================").ifPresent(System.out::println);
        future.get();
    }
}
