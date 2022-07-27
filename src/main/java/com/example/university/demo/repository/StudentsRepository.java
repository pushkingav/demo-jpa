package com.example.university.demo.repository;

import com.example.university.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    Student findStudentByName(String name);

    Student findById(long id);

    List<Student> findAll();
}
