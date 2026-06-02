package com.example.CrudByJpa.service;

import com.example.CrudByJpa.model.Student;
import com.example.CrudByJpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Add a new student
    public void addStudent(Student std) {
        repo.save(std);
    }

    // Get student by Roll Number (ID)
    public Student getStudentByRno(int rno) {
        return repo.findById(rno).orElse(null);
    }

    // Update student
    public void updateStudent(Student std) {
        repo.save(std);
    }

    // Delete student
    public void deleteStudent(int rno) {
        repo.deleteById(rno);
    }
}