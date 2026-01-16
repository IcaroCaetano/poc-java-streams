package com.myprojecticaro.poc_java_streams.supplier;

import java.util.function.Supplier;

public class SafeSupplier implements Supplier<String> {

    @Override
    public String get() {
        try {
            if (Math.random() < 0.3) {
                throw new RuntimeException("Simulated failure");
            }
            return "OK";
        } catch (Exception e) {
            return "FALLBACK";
        }
    }
}
