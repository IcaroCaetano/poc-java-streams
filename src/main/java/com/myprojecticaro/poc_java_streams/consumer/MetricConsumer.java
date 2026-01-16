package com.myprojecticaro.poc_java_streams.consumer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class MetricConsumer<T> implements Consumer<T> {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void accept(T value) {
        counter.incrementAndGet();
        System.out.println("📊 Total processado: " + counter.get());
    }
}
