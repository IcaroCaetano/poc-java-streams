package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class StringConcatBinaryOperatorExample {

    public void execute() {
        List<String> words = List.of("Java", "Streams", "BinaryOperator");

        BinaryOperator<String> concatOperator = (a, b) -> a + " " + b;

        String result = words.stream()
                .reduce(concatOperator)
                .orElse("");

        System.out.println("Concatenation result: " + result);
    }
}

