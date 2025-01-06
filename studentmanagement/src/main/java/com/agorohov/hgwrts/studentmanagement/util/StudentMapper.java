package com.agorohov.hgwrts.studentmanagement.util;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.entity.Student;

public final class StudentMapper {

    public static StudentDto entityToDto(Student student) {
        StudentDto result = new StudentDto();
        result.setId(student.getId());
        result.setName(student.getName());
        result.setFaculty(student.getFaculty());
        return result;
    }

    public static Student dtoToEntity(StudentDto studentDto) {
        Student result = new Student();
        result.setId(studentDto.getId());
        result.setName(studentDto.getName());
        result.setFaculty(studentDto.getFaculty());
        return result;
    }
}
