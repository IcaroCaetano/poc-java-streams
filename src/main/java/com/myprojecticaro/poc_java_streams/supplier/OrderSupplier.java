package com.myprojecticaro.poc_java_streams.supplier;

import com.myprojecticaro.poc_java_streams.model.Order;

import java.util.UUID;
import java.util.function.Supplier;

public class OrderSupplier implements Supplier<Order> {

    @Override
    public Order get() {
        return new Order(
                UUID.randomUUID().toString(),
                Math.random() * 1000
        );
    }
}

