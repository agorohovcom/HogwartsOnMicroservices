package com.agorohov.hgwrts.studentmanagement.controller;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable(name = "id") Long id) {
        StudentDto result = studentService.getStudent(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> result = studentService.getAllStudents();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        StudentDto result = studentService.addStudent(studentDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/assign_faculty")
    public ResponseEntity<StudentDto> assignFaculty(@RequestBody StudentDto studentDto) {
        StudentDto result = studentService.assignFaculty(studentDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}