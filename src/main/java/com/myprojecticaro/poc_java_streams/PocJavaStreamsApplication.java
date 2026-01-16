package com.myprojecticaro.poc_java_streams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocJavaStreamsApplication {

	public static void main(String[] args) {
		// supplier
		var supplier = new com.example.streams.supplier.RandomNumberSupplier();
		// consumer
        var consumer = new com.example.streams.consumer.LoggingConsumer();
        var service = new com.example.streams.service.StreamProcessingService();

        service.process(supplier, consumer);
	}

}
