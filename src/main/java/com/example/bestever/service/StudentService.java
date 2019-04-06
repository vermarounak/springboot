package com.example.bestever.service;

import com.example.bestever.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();
}
