package com.myprojecticaro.poc_java_streams.callable;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<String> {

    @Override
    public String call() {
        System.out.println("🧠 Executando SimpleCallable...");
        return "Resultado OK";
    }
}
