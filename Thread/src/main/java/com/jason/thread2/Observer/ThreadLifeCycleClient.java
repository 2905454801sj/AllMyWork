package com.jason.thread2.Observer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ThreadLifeCycleClient{
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList(1,2));
    }
}
