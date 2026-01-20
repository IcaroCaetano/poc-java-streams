package com.myprojecticaro.poc_java_streams.runnable;

public class CounterRunnable implements Runnable {

    private int counter;

    public CounterRunnable(int start) {
        this.counter = start;
    }

    @Override
    public void run() {
        counter++;
        System.out.println("🔢 CounterRunnable current value: " + counter);
    }
}