package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BinaryOperator;

public class BigDecimalSumBinaryOperatorExample {

    public void execute() {
        List<BigDecimal> values = List.of(
                new BigDecimal("10.50"),
                new BigDecimal("20.30"),
                new BigDecimal("5.20")
        );

        BinaryOperator<BigDecimal> sumOperator = BigDecimal::add;

        BigDecimal total = values.stream()
                .reduce(BigDecimal.ZERO, sumOperator);

        System.out.println("BigDecimal total: " + total);
    }
}

