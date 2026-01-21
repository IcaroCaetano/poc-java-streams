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

````java
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

````java
Stream.generate(new IncrementalSupplier())
.limit(5)
.forEach(System.out::println);
````

📌 *Key concept:* Suppliers are only executed when the stream reaches a terminal operation.

## 🧩 Runnable

### What is it?

Runnable represents a task to be executed, without input parameters and without a return value.

````java
void run();
````

### Typical Use Cases

- Background jobs

- Asynchronous processing

- Workers and tasks

- Thread execution

### Examples in this POC

- Simple runnable task

- Stateful runnable

- Heavy task simulation

- Runnable that wraps a Consumer

- Runnable executed via Thread

#### Example

````java
Runnable task = () -> System.out.println("Running task");
new Thread(task).start();
````

📌 *Key concept:* Runnable represents execution, not data transformation.

## 🔗 Combining Supplier, Consumer, and Runnable

One of the strengths of functional interfaces is how naturally they compose.

### Conceptual Pipeline

````
Supplier → Consumer → Runnable
````

Example

````java
Supplier<String> supplier = () -> "Event";
Consumer<String> consumer = v -> System.out.println(v);


Runnable task = new ConsumerRunnable<>(supplier.get(), consumer);
task.run();
````

This demonstrates:

- Data generation (Supplier)

- Action definition (Consumer)

- Task execution (Runnable)

## 🚀 Application Entry Point

The Application class acts as an orchestrator, executing:

- All Supplier examples

- Multiple Consumer strategies

- Runnable executions (sync and async)

This makes the POC easy to run and understand step by step.

## 📚 Key Concepts Demonstrated

- Lazy evaluation with Streams

- Side effects and terminal operations

- Functional composition (andThen)

- Stateful vs stateless components

- Synchronous vs asynchronous execution

## 🔮 Possible Next Steps

- Replace Thread with ExecutorService

- Introduce Callable and Future

- Add CompletableFuture

- Convert to Spring Boot (CommandLineRunner)

- Map concepts to classic design patterns (Producer–Consumer, Pipeline)

## ✅ Conclusion

This POC provides a clear and practical exploration of Supplier, Consumer, and Runnable, showing how Java’s functional interfaces enable expressive, modular, and modern application design.
