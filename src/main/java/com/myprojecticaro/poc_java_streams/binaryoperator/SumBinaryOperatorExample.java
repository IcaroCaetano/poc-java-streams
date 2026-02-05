package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class SumBinaryOperatorExample {

    public void execute() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        BinaryOperator<Integer> sumOperator = (a, b) -> a + b;

        int result = numbers.stream()
                .reduce(0, sumOperator);

        System.out.println("Sum result: " + result);
    }
}

