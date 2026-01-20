package com.myprojecticaro.poc_java_streams.runnable;

import java.util.function.Consumer;

public class ConsumerRunnable<T> implements Runnable {

    private final T value;
    private final Consumer<T> consumer;

    public ConsumerRunnable(T value, Consumer<T> consumer) {
        this.value = value;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.accept(value);
    }
}
