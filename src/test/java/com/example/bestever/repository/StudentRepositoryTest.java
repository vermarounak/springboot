package com.example.bestever.repository;

import com.example.bestever.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void save() {
        Student student = new Student("Student1", "Passport1");

        final Student savedStudent = studentRepository.save(student);

        assertThat("saved student ", savedStudent.getId(), is(notNullValue()));
    }

    @Test
    void findById() {
        Student student = new Student("Student1", "Passport1");
        Student savedStudent = studentRepository.save(student);

        final Optional<Student> studentOptional = studentRepository.findById(savedStudent.getId());

        assertThat("found student ", studentOptional, is(not(Optional.empty())));
        final Student foundStudent = studentOptional.get();
        assertThat("found student name ", foundStudent.getName(), is("Student1"));
        assertThat("found student passport number ", foundStudent.getPassportNumber(),
                is("Passport1"));
    }

    @Test
    void findById_notFound() {
        studentRepository.save(new Student("Student1", "Passport1"));

        final Optional<Student> studentOptional = studentRepository.findById(5678L);

        assertThat("found student ", studentOptional, is(Optional.empty()));
    }

    @Test
    void findAll() {
        final List<Student> students = studentRepository.findAll();

        assertThat("already loaded students ", students, hasSize(2));
    }
}