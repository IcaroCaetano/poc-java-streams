package com.example.streams.consumer;

import java.util.function.Consumer;

public class LoggingConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer value) {
        System.out.println("Consuming value: " + value);
    }
}

