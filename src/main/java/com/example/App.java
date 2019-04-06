package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /*@Override
    public void run(String... args) {
        createTwoStudents().forEach(studentService::save);
    }

    private List<Student> createTwoStudents() {
        return Arrays.asList(
                new Student("Student1", "Passport1"),
                new Student("Student2", "Passport2")
        );
    }*/
}
