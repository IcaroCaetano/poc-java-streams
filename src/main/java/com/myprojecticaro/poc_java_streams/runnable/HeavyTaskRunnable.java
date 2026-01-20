package com.myprojecticaro.poc_java_streams.runnable;

public class HeavyTaskRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("⏳ Starting heavy task...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Heavy task finalizing");
    }
}
