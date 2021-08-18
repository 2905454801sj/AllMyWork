package com.jason.thread2.Singleton;

import java.util.Optional;
import java.util.stream.IntStream;

public class SingletonObject7 {
    private SingletonObject7(){

    }

    private enum Singteon{
        INSTANCE;

        private final SingletonObject7 instance;

        Singteon(){
            instance=new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }
    public static SingletonObject7 getInstance(){
        return Singteon.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0,50).forEach(i -> {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    Optional.of(SingletonObject7.getInstance()).ifPresent(System.out::println);
                }
            }.start();
        });
    }
}
