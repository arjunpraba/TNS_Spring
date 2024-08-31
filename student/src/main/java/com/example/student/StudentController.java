package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Get a single student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    // Update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        return studentRepository.save(student);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentRepository.delete(student);
    }
}
