package me.kodey.service;

import me.kodey.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/students")
public interface StudentClientService {

    @GetExchange
    List<Student> getAllStudents();
}
