package com.example.studentmvc.service;

import com.example.studentmvc.model.Student;
import com.example.studentmvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public String addStudent(Student student) {

        if(repository.findByEmail(student.getEmail()).isPresent()){
            return "Student with this email already exists!";
        }

        repository.save(student);
        return "Welcome " + student.getName() + "!";
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
}