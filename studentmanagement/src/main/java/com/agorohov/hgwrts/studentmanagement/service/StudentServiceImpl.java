package com.agorohov.hgwrts.studentmanagement.service;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.entity.Student;
import com.agorohov.hgwrts.studentmanagement.exception.StudentNameAlreadyExistsException;
import com.agorohov.hgwrts.studentmanagement.repository.StudentRepository;
import com.agorohov.hgwrts.studentmanagement.util.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        if(studentRepository.existsByName(studentDto.getName())) {
            throw new StudentNameAlreadyExistsException("Уже есть студент с именем " + studentDto.getName());
        }
        Student result = studentRepository.save(StudentMapper.dtoToEntity(studentDto));
        return StudentMapper.entityToDto(result);
    }
}
