package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            IStudentRepository repository) {
        return args -> {
            Student vas = new Student(
                    1L,
                    "Vasilis",
                    "vas@gmail.com",
                    LocalDate.of(2001, Month.MARCH, 19)
            );

            Student niko = new Student(
                    "Nikola",
                    "nik@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 4)
            );

            repository.saveAll(
                    List.of(vas, niko)
            );
        };
    }
}
