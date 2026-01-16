package com.myprojecticaro.poc_java_streams.supplier;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class DateTimeSupplier implements Supplier<LocalDateTime> {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}
