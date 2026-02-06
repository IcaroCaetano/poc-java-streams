package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorWithAndThenExample {

    public void execute() {

        UnaryOperator<String> trim = String::trim;
        UnaryOperator<String> uppercase = String::toUpperCase;

        Function<String, String> composed = trim.andThen(uppercase);

        System.out.println(composed.apply("  java streams  "));

        System.out.println(composed.apply("  java streams  "));
    }
}
