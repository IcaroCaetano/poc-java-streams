package com.myprojecticaro.poc_java_streams.unaryoperator;

import java.util.List;
import java.util.function.UnaryOperator;

public class DomainObjectUnaryOperatorExample {

    public void execute() {

        System.out.println("Inicio DomainObjectUnaryOperatorExample");

        List<User> users = List.of(
                new User("icaro", false),
                new User("admin", false)
        );

        UnaryOperator<User> activateUser = user -> new User(user.name, true);

        users.stream()
                .map(activateUser)
                .forEach(System.out::println);

        System.out.println("Fim DomainObjectUnaryOperatorExample");
        System.out.println();
    }

    static class User {
        String name;
        boolean active;

        User(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        @Override
        public String toString() {
            return name + " | active=" + active;
        }
    }
}
