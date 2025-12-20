package com.stdmgm.demo.controller;

import com.stdmgm.demo.model.Student;
import com.stdmgm.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service; 

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 1. Register Student
    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {

        // Validation
        if (student.getName() == null || student.getName().trim().isEmpty() ||
            student.getCourse() == null || student.getCourse().trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Name and course must not be empty");
        }

        if (service.existsById(student.getId())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Student with ID " + student.getId() + " already exists");
        }

        service.registerStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }

    // 2. Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // 3. Get Student by ID
  @GetMapping("/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable int id) {
    return service.getStudentById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}


    // 4. Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        boolean deleted = service.deleteStudent(id);

        if (deleted) {
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found");
        }
    }
}
