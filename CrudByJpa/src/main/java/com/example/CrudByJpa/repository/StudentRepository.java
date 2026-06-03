package com.example.CrudByJpa.repository;

import com.example.CrudByJpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student,Integer> {

    // Derived Query Method
    List<Student> findByGenderAndTech(
            String gender,
            String tech
    );

    // Native Query
    @Query(
            value = "SELECT * FROM student WHERE gender = :gender AND tech = :tech",
            nativeQuery = true
    )
    List<Student> getStudentByGenderAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    );

}
