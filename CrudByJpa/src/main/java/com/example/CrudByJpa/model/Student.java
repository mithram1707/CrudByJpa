package com.example.CrudByJpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    private int rollno;

    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "tech should not be empty")
    private String tech;

    @NotBlank(message = "gender should not be empty")
    private String gender;

    public Student() {
    }

    public Student(int rollno, String name, String tech, String gender) {
        this.rollno = rollno;
        this.name = name;
        this.tech = tech;
        this.gender = gender;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}