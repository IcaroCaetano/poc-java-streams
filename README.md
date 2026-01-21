# POC JAVA STREAMS

This repository contains a Proof of Concept (POC) demonstrating the practical use of three core Java functional interfaces:

- Supplier

- Consumer

- Runnable

The goal is to show how these interfaces can be combined with Java Streams and threads to build clean, expressive, and extensible processing pipelines.


## 🎯 Objectives

- Demonstrate how Supplier, Consumer, and Runnable work in isolation

- Show how they integrate naturally with Java Streams

- Highlight lazy evaluation, side effects, and task execution

- Provide a didactic and extensible POC suitable for learning or presentations

## 🧩 Supplier

#### What is it?

`Supplier<T>` represents a function that produces values without receiving any input.

````
T get();
````

### Typical Use Cases

- Generating data on demand

- Creating infinite or lazy streams

- Mocking data for tests

- Producing domain objects or events

### Examples in this POC

- Incremental value generation

- Date and time generation

- omain object creation (Order)

- Resilient supplier with fallback logic

### Example

````
Stream.generate(new IncrementalSupplier())
.limit(5)
.forEach(System.out::println);
````

📌 *Key concept:* Suppliers are only executed when the stream reaches a terminal operation.
