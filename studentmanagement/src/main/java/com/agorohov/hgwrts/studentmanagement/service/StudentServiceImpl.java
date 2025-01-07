package com.agorohov.hgwrts.studentmanagement.service;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.entity.Student;
import com.agorohov.hgwrts.studentmanagement.exception.FacultyAlreadyAssignedException;
import com.agorohov.hgwrts.studentmanagement.exception.StudentNameAlreadyExistsException;
import com.agorohov.hgwrts.studentmanagement.exception.StudentNotFoundException;
import com.agorohov.hgwrts.studentmanagement.repository.StudentRepository;
import com.agorohov.hgwrts.studentmanagement.util.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public StudentDto getStudent(Long id) {
        Optional<Student> optionalStudentDto = studentRepository.findById(id);
        if (optionalStudentDto.isEmpty()) {
            throw new StudentNotFoundException("Нет студента с id " + id);
        }
        Student result = optionalStudentDto.get();
        return StudentMapper.entityToDto(result);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::entityToDto)
                .toList();
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudentDto = studentRepository.findById(id);
        if (optionalStudentDto.isEmpty()) {
            throw new StudentNotFoundException("Нет студента с id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        if (studentRepository.existsByName(studentDto.getName())) {
            throw new StudentNameAlreadyExistsException("Уже есть студент с именем " + studentDto.getName());
        }
        Student result = studentRepository.save(StudentMapper.dtoToEntity(studentDto));
        return StudentMapper.entityToDto(result);
    }

    @Override
    public StudentDto assignFaculty(StudentDto studentDto) {
        if(studentDto.getFaculty() != null){
            throw new FacultyAlreadyAssignedException("У студента уже есть факультет: " + studentDto.getFaculty());
        }
        return restTemplate.postForObject(
                "http://localhost:3456/assign_faculty",
                studentDto,
                StudentDto.class,
                studentDto
        );
    }
}
