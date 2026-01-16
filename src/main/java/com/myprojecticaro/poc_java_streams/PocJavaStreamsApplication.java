package com.myprojecticaro.poc_java_streams;

import com.myprojecticaro.poc_java_streams.consumer.LoggingConsumer;
import com.myprojecticaro.poc_java_streams.consumer.MetricConsumer;
import com.myprojecticaro.poc_java_streams.service.StreamProcessingService;
import com.myprojecticaro.poc_java_streams.supplier.IncrementalSupplier;
import com.myprojecticaro.poc_java_streams.supplier.RandomNumberSupplier;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SpringBootApplication
public class PocJavaStreamsApplication {

	public static void main(String[] args) {
		// supplier
		var supplier = new RandomNumberSupplier();
		// consumer
        var consumer = new LoggingConsumer();
        var service = new StreamProcessingService();

        service.process(supplier, consumer);


        System.out.println("===== JAVA STREAMS | SUPPLIER & CONSUMER POC =====");

        StreamProcessingService service = new StreamProcessingService();

        /* =====================================================
           1️⃣ IncrementalSupplier
        ===================================================== */
        System.out.println("\n--- IncrementalSupplier ---");

        Supplier<Integer> incrementalSupplier = new IncrementalSupplier();
        Consumer<Integer> logIntConsumer = new LogConsumer<>();

        Stream.generate(incrementalSupplier)
                .limit(5)
                .forEach(logIntConsumer);

        /* =====================================================
           2️⃣ DateTimeSupplier
        ===================================================== */
        System.out.println("\n--- DateTimeSupplier ---");

        Supplier<LocalDateTime> dateTimeSupplier = new DateTimeSupplier();
        Consumer<LocalDateTime> logDateConsumer = new LogConsumer<>();

        Stream.generate(dateTimeSupplier)
                .limit(3)
                .forEach(logDateConsumer);

        /* =====================================================
           3️⃣ OrderSupplier (objeto de domínio)
        ===================================================== */
        System.out.println("\n--- OrderSupplier ---");

        Supplier<Order> orderSupplier = new OrderSupplier();
        Consumer<Order> orderLogConsumer = new LogConsumer<>();

        Stream.generate(orderSupplier)
                .filter(order -> order.value() > 500)
                .limit(3)
                .forEach(orderLogConsumer);

        /* =====================================================
           4️⃣ SafeSupplier (fallback)
        ===================================================== */
        System.out.println("\n--- SafeSupplier ---");

        Supplier<String> safeSupplier = new SafeSupplier();
        Consumer<String> logStringConsumer = new LogConsumer<>();

        Stream.generate(safeSupplier)
                .limit(5)
                .forEach(logStringConsumer);

        /* =====================================================
           5️⃣ Supplier simples + Consumer encadeado
        ===================================================== */
        System.out.println("\n--- Supplier + Consumer encadeado ---");

        Supplier<String> uuidSupplier =
                () -> UUID.randomUUID().toString();

        Consumer<String> logConsumer =
                v -> System.out.println("📘 LOG: " + v);

        Consumer<String> persistConsumer =
                v -> System.out.println("💾 Persistindo: " + v);

        Consumer<String> compositeConsumer =
                logConsumer.andThen(persistConsumer);

        Stream.generate(uuidSupplier)
                .limit(3)
                .forEach(compositeConsumer);

        /* =====================================================
           6️⃣ Supplier + MetricConsumer
        ===================================================== */
        System.out.println("\n--- MetricConsumer ---");

        MetricConsumer<Integer> metricConsumer = new MetricConsumer<>();

        Stream.generate(new IncrementalSupplier())
                .limit(5)
                .forEach(metricConsumer);

        /* =====================================================
           7️⃣ Supplier + peek (debug no pipeline)
        ===================================================== */
        System.out.println("\n--- Supplier + peek ---");

        Stream.generate(new IncrementalSupplier())
                .peek(n -> System.out.println("👀 Gerado: " + n))
                .filter(n -> n % 2 == 0)
                .limit(5)
                .forEach(v -> System.out.println("✅ Consumido: " + v));

        System.out.println("\n===== FIM DA EXECUÇÃO =====");
	}

}
