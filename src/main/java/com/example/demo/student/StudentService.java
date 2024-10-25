package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final IStudentRepository _studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return _studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
