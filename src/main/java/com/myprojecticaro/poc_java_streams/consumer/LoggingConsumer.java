package com.myprojecticaro.poc_java_streams.consumer;

import java.util.function.Consumer;

public class LoggingConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer value) {
        System.out.println("Consuming value: " + value);
    }
}

