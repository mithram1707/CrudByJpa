package com.example.CrudByJpa.Controller;

import com.example.CrudByJpa.model.Student;
import com.example.CrudByJpa.service.StudentService;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping("/student")
    public String addStudent(

            @Valid
            @RequestBody Student std

    ){
        service.addStudent(std);
        return "Student Added Successfully";
    }

    @PutMapping("/student")
    public String updateStudent(

            @Valid
            @RequestBody Student std

    ){
        service.updateStudent(std);
        return "Updated Successfully";
    }

    @DeleteMapping("/student/{rollno}")
    public String deleteStudent(
            @PathVariable int rollno
    ){
        service.deleteStudent(rollno);
        return "Deleted Successfully";
    }

    // Derived Query
    @GetMapping("/student/custom")
    public List<Student> getStudentByGenderAndTech(

            @RequestParam String gender,
            @RequestParam String tech

    ){
        return service.getStudentByGenderAndTech(
                gender,
                tech
        );
    }

    // Native Query
    @GetMapping("/student/filter")
    public List<Student> filterStudents(

            @RequestParam String gender,
            @RequestParam String tech

    ){
        return service.filterStudents(
                gender,
                tech
        );
    }
    @GetMapping("/student/page")
    public Page<Student> getStudentsWithPagination(

            @RequestParam int page,
            @RequestParam int size

    ){
        return service.getStudentsWithPagination(
                page,
                size
        );
    }
}