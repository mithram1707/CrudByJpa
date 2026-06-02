package com.example.CrudByJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CrudByJpa.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}