package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.util.List;
import java.util.function.UnaryOperator;

public class IncrementUnaryOperatorExample {

    public void execute() {

        List<Integer> numbers = List.of(1, 2, 3, 4);

        UnaryOperator<Integer> increment = value -> value + 1;

        numbers.stream()
                .map(increment)
                .forEach(System.out::println);
    }
}
