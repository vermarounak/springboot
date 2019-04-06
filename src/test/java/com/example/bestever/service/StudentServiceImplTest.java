package com.example.bestever.service;

import com.example.bestever.entity.Student;
import com.example.bestever.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void save() {
        Student student = mock(Student.class);

        when(studentRepository.save(student)).thenReturn(student);

        final Student savedStudent = studentService.save(student);

        assertThat("saved student ", savedStudent, is(student));
        verify(studentRepository).save(student);
    }

    @Test
    void findById() {
        Long id = 12345L;
        Student student = mock(Student.class);

        when(studentRepository.findById(id)).thenReturn(ofNullable(student));

        final Optional<Student> studentOptional = studentService.findById(id);

        assertThat("retrieved student ", studentOptional.get(), is(student));
        verify(studentRepository).findById(id);
    }

    @Test
    void findAll() {
        Student student = mock(Student.class);

        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));

        final List<Student> studentList = studentService.findAll();

        assertThat("student list ", studentList, hasSize(1));
        assertThat("student list contains ", studentList, hasItem(student));
        verify(studentRepository).findAll();
    }
}