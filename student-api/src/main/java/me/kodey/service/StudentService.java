package me.kodey.service;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import me.kodey.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static final List<Student> STUDENTS = new ArrayList<>();

    private final ObservationRegistry observationRegistry;

    public Student addStudent(Student student) {
        STUDENTS.add(student);
        // return student;
        return Observation
                .createNotStarted("addStudent", observationRegistry)
                .observe(() -> student);
    }

    public List<Student> getAllStudents() {
        // return STUDENTS;
        return Observation
                .createNotStarted("getAllStudents", observationRegistry)
                .observe(() -> STUDENTS);
    }

    public Student getStudent(String id) {
        return Observation
                .createNotStarted("getStudent", observationRegistry)
                .observe(() -> getStudentOrThrow(id));
    }

    private static Student getStudentOrThrow(String id) {
        return STUDENTS
                .stream()
                .filter(student -> id.equals(student.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student does not exist!"));
    }
}
