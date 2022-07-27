package com.example.university.demo.repository;

import com.example.university.demo.model.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversitiesRepository extends CrudRepository<University, Long> {
    List<University> findAll();

    List<University> findByDescription(String description);

    University findById(long id);
}
