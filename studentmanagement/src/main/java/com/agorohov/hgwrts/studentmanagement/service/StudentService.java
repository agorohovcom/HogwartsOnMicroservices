package com.agorohov.hgwrts.studentmanagement.service;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(StudentDto studentDto);

    StudentDto getStudent(Long id);

    List<StudentDto> getAllStudents();

    void deleteStudent(Long id);

    StudentDto assignFaculty(StudentDto studentDto);
}
