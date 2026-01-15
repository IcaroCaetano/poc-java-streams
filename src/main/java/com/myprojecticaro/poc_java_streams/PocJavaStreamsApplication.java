package com.myprojecticaro.poc_java_streams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocJavaStreamsApplication {

	public static void main(String[] args) {
		// supplier
		var supplier = new RandomNumberSupplier();
		// consumer
        var consumer = new LoggingConsumer();
        var service = new StreamProcessingService();

        service.process(supplier, consumer);
	}

}
