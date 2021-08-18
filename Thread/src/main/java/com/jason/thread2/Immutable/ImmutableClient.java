package com.jason.thread2.Immutable;

import java.util.stream.IntStream;

public class ImmutableClient {
    public static void main(String[] args) {
        //共享数据
        Person person = new Person("Jason", "JiangSu");

        IntStream.rangeClosed(1,5).forEach(i->
            new PersonThread(person).start()
        );


    }
}
