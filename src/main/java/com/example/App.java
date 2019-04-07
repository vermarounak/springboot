package com.example;

import com.example.bestever.entity.Student;
import com.example.bestever.repository.StudentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ApplicationRunner populateStudents(StudentRepository studentRepository) {
        return args -> createTwoStudents().forEach(studentRepository::save);
    }

    private List<Student> createTwoStudents() {
        return Arrays.asList(
                new Student("Student1", "Passport1"),
                new Student("Student2", "Passport2")
        );
    }
}
