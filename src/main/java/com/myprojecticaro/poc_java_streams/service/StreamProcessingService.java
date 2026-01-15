
package com.example.streams.service;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamProcessingService {

    public void process(
            Supplier<Integer> supplier,
            Consumer<Integer> consumer
    ) {

        Stream.generate(supplier)         // uses Supplier
              .filter(n -> n % 2 == 0)    // only even numbers
              .map(n -> n * 2)            // doubles the value
              .limit(5)                   // limits execution
              .forEach(consumer);         // uses Consumer
}
