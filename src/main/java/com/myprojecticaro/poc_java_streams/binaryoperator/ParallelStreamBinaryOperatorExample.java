package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class ParallelStreamBinaryOperatorExample {

    public void execute() {

        System.out.println("Inicio ParallelStreamBinaryOperatorExample");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        BinaryOperator<Integer> sumOperator = Integer::sum;

        int result = numbers.parallelStream()
                .reduce(0, sumOperator);

        System.out.println("Parallel sum result: " + result);

        System.out.println("Fim ParallelStreamBinaryOperatorExample");
        System.out.println();
    }
}
