package com.agorohov.hgwrts.studentmanagement.controller;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        StudentDto result = studentService.addStudent(studentDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }
}