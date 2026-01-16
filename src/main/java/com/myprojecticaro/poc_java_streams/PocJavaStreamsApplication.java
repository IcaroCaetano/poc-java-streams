package com.myprojecticaro.poc_java_streams;

import com.myprojecticaro.poc_java_streams.consumer.LoggingConsumer;
import com.myprojecticaro.poc_java_streams.service.StreamProcessingService;
import com.myprojecticaro.poc_java_streams.supplier.RandomNumberSupplier;
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
