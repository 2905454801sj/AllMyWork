package com.jason.thread2.Immutable;

import java.util.Optional;

public class ImmutablePerformance {
    public static void main(String[] args) {
        long starttime=System.currentTimeMillis();
        /*ChangableObj changableObj=new ChangableObj();
        changableObj.setName("ASD");*/
        ImmutableObj immutableObj=new ImmutableObj("Jason");

        for(long i=0l;i<10000;i++){
            //Optional.of(changableObj.toString()).ifPresent(System.out::println);
            Optional.of(immutableObj.toString()).ifPresent(System.out::println);
        }
        long endtime=System.currentTimeMillis();
        Optional.of("cost:"+(endtime-starttime)).ifPresent(System.out::println);
    }
}
final class ImmutableObj{
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class ChangableObj{
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "Changable{" +
                "name='" + name + '\'' +
                '}';
    }
}
