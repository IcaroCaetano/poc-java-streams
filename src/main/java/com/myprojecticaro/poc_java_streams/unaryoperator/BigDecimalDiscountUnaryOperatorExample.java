package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.UnaryOperator;

public class BigDecimalDiscountUnaryOperatorExample {

    public void execute() {

        List<BigDecimal> prices = List.of(
                new BigDecimal("100.00"),
                new BigDecimal("200.00")
        );

        UnaryOperator<BigDecimal> applyDiscount = price -> price.multiply(new BigDecimal("0.90"));

        prices.stream()
                .map(applyDiscount)
                .forEach(System.out::println);
    }
}
