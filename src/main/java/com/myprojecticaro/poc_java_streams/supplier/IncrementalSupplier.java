package com.myprojecticaro.poc_java_streams.supplier;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class IncrementalSupplier implements Supplier<Integer> {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Integer get() {
        return counter.incrementAndGet();
    }
}
