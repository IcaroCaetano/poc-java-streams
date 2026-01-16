package com.myprojecticaro.poc_java_streams.consumer;

import java.util.function.Consumer;

public class LogConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T value) {
        System.out.println("📘 LOG: " + value);
    }
}

