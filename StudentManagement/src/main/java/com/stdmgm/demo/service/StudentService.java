package com.stdmgm.demo.service;

import com.stdmgm.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Register student
    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Get student by ID
    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    // Check if ID exists
    public boolean existsById(int id) {
        return students.stream().anyMatch(s -> s.getId() == id);
    }

    // Delete student
    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}
