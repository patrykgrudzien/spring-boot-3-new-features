package me.kodey.service;

import lombok.RequiredArgsConstructor;
import me.kodey.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static final List<Student> STUDENTS = new ArrayList<>();

    public Student addStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    public Student getStudent(String id) {
        return STUDENTS
                .stream()
                .filter(student -> id.equals(student.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student does not exist!"));
    }
}
