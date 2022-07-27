package com.example.university.demo;

import com.example.university.demo.model.Student;
import com.example.university.demo.model.University;
import com.example.university.demo.repository.StudentsRepository;
import com.example.university.demo.repository.UniversitiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UniversitiesRepository universitiesRepository,
                                  StudentsRepository studentsRepository) {
        return args -> {
            universitiesRepository.save(new University("University of Maryland"));
            LOGGER.info("Saved one University");

            University university = universitiesRepository.findAll().get(0);
            LOGGER.info("Retrieved a University with description {}", university.getDescription());

            studentsRepository.save(new Student("John Doe", university));
            studentsRepository.save(new Student("Mary Anderson", university));
            studentsRepository.save(new Student("Robert Daughtry", university));
            studentsRepository.save(new Student("Alice March", university));
            LOGGER.info("Saved 4 students");

            List<Student> students = studentsRepository.findAll();
            LOGGER.info("Fetched {} students from the repository", students.size());

            students.forEach(student -> {
                LOGGER.info("Student name: {}, university: {}",
                        student.getName(), student.getUniversity().getDescription());
            });
        };
    }

}
