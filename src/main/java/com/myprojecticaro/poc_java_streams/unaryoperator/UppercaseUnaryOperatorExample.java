package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.util.List;
import java.util.function.UnaryOperator;

public class UppercaseUnaryOperatorExample {

    public void execute() {

        List<String> names = List.of("java", "streams", "lambda");

        UnaryOperator<String> toUppercase = String::toUpperCase;

        names.stream()
                .map(toUppercase)
                .forEach(System.out::println);
    }
}
