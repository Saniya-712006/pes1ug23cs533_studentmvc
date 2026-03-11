package com.example.studentmvc.controller;

import com.example.studentmvc.model.Student;
import com.example.studentmvc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student, Model model){

        String message = service.addStudent(student);

        model.addAttribute("message", message);
        model.addAttribute("student", new Student());
        model.addAttribute("students", service.getAllStudents());

        return "index";
    }
}