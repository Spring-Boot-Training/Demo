package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return _studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        _studentService.addNewStudent(student);
    }
}
