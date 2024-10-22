package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Vasilis",
                        "vas@gmail.com",
                        LocalDate.of(2001, Month.MARCH, 19),
                        23
                ));
    }
}
