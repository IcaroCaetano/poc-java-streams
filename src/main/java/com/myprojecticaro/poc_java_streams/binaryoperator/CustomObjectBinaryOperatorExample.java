package com.myprojecticaro.poc_java_streams.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;

public class CustomObjectBinaryOperatorExample {

    public void execute() {
        List<Order> orders = List.of(
                new Order(1, 100),
                new Order(2, 250),
                new Order(3, 150)
        );

        BinaryOperator<Order> totalOperator =
                (o1, o2) -> new Order(0, o1.total + o2.total);

        Order result = orders.stream()
                .reduce(totalOperator)
                .orElseThrow();

        System.out.println("Total order value: " + result.total);
    }

    static class Order {
        int id;
        int total;

        Order(int id, int total) {
            this.id = id;
            this.total = total;
        }
    }
}
