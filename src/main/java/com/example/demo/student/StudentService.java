package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
        Optional<Student> studentOptional = _studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        _studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = _studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        _studentRepository.deleteById(id);
    }
}
