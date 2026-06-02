package com.example.CrudByJpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.CrudByJpa.model.Student;
import com.example.CrudByJpa.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student std) {
        return repository.save(std);
    }
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student std){
        return repository.save(std);
    }

    @DeleteMapping("/student/{rollno}")
    public String deleteStudent(@PathVariable int rollno){
        repository.deleteById(rollno);
        return "Deleted Successfully";
    }

}