package com.example.streams.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class RandomNumberSupplier implements Supplier<Integer> {

    private final Random random = new Random();

    @Override
    public Integer get() {
        System.out.println("Generating number...");
        return random.nextInt(100);
    }
}

