package com.example.bestever.controller;

import com.example.bestever.entity.Student;
import com.example.bestever.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private static final String SEARCH_STUDENT_PATH = "/find";

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(SEARCH_STUDENT_PATH)
    public Student findById(@RequestParam(name = "id") long id) {
        final Instant startTime = Instant.now();

        final Student student = studentService.findById(id).orElse(null);

        LOG.info("Time taken to search student with id: {} is {} ms",
                id, Duration.between(startTime, Instant.now()).toMillis());

        return student;
    }

    @PostMapping("/save")
    public void save(@Valid @RequestBody Student student){
        final Instant startTime = Instant.now();

        studentService.save(student);

        LOG.info("Time taken to save student {} is {}ms",
                student, Duration.between(startTime, Instant.now()).toMillis());
    }
}
