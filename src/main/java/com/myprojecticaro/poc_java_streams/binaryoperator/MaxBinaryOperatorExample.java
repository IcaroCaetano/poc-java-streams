package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class MaxBinaryOperatorExample {

    public void execute() {
       System.out.println("Inicio MaxBinaryOperatorExample");
        
        List<Integer> values = List.of(10, 40, 5, 30);

        BinaryOperator<Integer> maxOperator = (a, b) -> a > b ? a : b;

        int max = values.stream().reduce(maxOperator).orElseThrow();

        System.out.println("Max value: " + max);

        System.out.println("Fim MaxBinaryOperatorExample");
        System.out.println();
    }
}

