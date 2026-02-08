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

## 🧩 BinaryOperator

### What is it?

BinaryOperator<T> represents a function that receives two values of the same type and returns one value of the same type.

It is a specialization of BiFunction<T, T, T> and is commonly used in reduction operations.


````java
T apply(T t1, T t2);
````

### Typical Use Cases

- Reducing a stream to a single value

- Aggregating numeric values (sum, max, min)

- Combining domain objects

- Merging partial results in parallel streams

- Implementing custom business aggregation rules

### Commonly Used With

- Stream.reduce(...)

- Collectors.reducing(...)

- Parallel streams (as a combiner)

### Examples in this POC

- Sum of integers

- Finding the maximum value

- String concatenation

- Financial aggregation using BigDecimal

- Reducing custom domain objects (Order)

- Safe usage with parallel streams

#### Example

````java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

BinaryOperator<Integer> sumOperator = Integer::sum;

int result = numbers.stream()
        .reduce(0, sumOperator);

System.out.println(result);

````

📌 Key concept:
BinaryOperator is fundamental for reduction logic.
When used in parallel streams, the operation must be associative and stateless to guarantee correct results.


## 🧩 UnaryOperator

What is it?

UnaryOperator<T> represents a function that receives one value and returns a value of the same type.

It is a specialization of Function<T, T> and is commonly used when you want to transform or modify a value without changing its type.

```java
T apply(T t);
```

### Typical Use Cases

- Transforming elements in a stream

- Applying mutations or adjustments to values

- Normalizing or formatting data

- Incrementing, decrementing, or updating values

- Applying business rules that keep the same type

### Commonly Used With

- Stream.map(...)

- Optional.map(...)

- Collections.replaceAll(...)

- List.replaceAll(...)

- Custom transformation pipelines

### Examples in this POC

- Incrementing numeric values

- Converting strings to uppercase or lowercase

- Applying discounts or adjustments to BigDecimal values

- Updating fields of domain objects (e.g., Order)

- Safe transformations in streams

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

UnaryOperator<Integer> incrementOperator = n -> n + 1;

List<Integer> result = numbers.stream()
        .map(incrementOperator)
        .toList();

System.out.println(result);
```



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
