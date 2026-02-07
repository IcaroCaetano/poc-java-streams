package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.util.List;
import java.util.function.UnaryOperator;

public class TrimUnaryOperatorExample {

    public void execute() {

        System.out.println("Inicio TrimUnaryOperatorExample");

        List<String> inputs = List.of("  java  ", " streams ", " lambda ");

        UnaryOperator<String> trim = String::trim;

        inputs.stream()
                .map(trim)
                .forEach(System.out::println);

        System.out.println("Fim TrimUnaryOperatorExample");
        System.out.println();
    }
}
