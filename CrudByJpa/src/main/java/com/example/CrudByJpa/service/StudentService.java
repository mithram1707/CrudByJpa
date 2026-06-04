package com.example.CrudByJpa.service;

import com.example.CrudByJpa.model.Student;
import com.example.CrudByJpa.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void addStudent(Student std) {
        repo.save(std);
    }

    public Student getStudentByRno(int rno) {
        return repo.findById(rno).orElse(null);
    }

    public void updateStudent(Student std) {
        repo.save(std);
    }

    public void deleteStudent(int rno) {
        repo.deleteById(rno);
    }

    // Derived Method
    public List<Student> getStudentByGenderAndTech(
            String gender,
            String tech
    ){
        return repo.findByGenderAndTech(gender, tech);
    }

    // Native Query Method
    public List<Student> filterStudents(
            String gender,
            String tech
    ){
        return repo.getStudentByGenderAndTech(
                gender,
                tech
        );
    }
    public Page<Student> getStudentsWithPagination(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }
}