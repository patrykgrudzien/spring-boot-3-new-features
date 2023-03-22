package me.kodey.controller;

import lombok.RequiredArgsConstructor;
import me.kodey.model.Student;
import me.kodey.service.StudentClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/students")
@RequiredArgsConstructor
public class StudentClientController {

    private final StudentClientService studentClientService;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentClientService.getAllStudents();
    }
}
