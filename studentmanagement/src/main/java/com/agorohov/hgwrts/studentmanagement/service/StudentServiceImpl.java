package com.agorohov.hgwrts.studentmanagement.service;

import com.agorohov.hgwrts.studentmanagement.dto.StudentDto;
import com.agorohov.hgwrts.studentmanagement.entity.Student;
import com.agorohov.hgwrts.studentmanagement.exception.FacultyAlreadyAssignedException;
import com.agorohov.hgwrts.studentmanagement.exception.StudentNameAlreadyExistsException;
import com.agorohov.hgwrts.studentmanagement.exception.StudentNotFoundException;
import com.agorohov.hgwrts.studentmanagement.repository.StudentRepository;
import com.agorohov.hgwrts.studentmanagement.util.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final WebClient webClient;

    public StudentServiceImpl(StudentRepository studentRepository, WebClient webClient) {
        this.studentRepository = studentRepository;
        this.webClient = webClient;
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

    // TODO сделать чтобы была проверка из бд нет ли факультета у studentDto перед назначением нового факультета
    // Использование WebClient
    @Override
    public StudentDto assignFaculty(StudentDto studentDto) {
        if (studentDto.getFaculty() != null) {
            throw new FacultyAlreadyAssignedException("У студента уже есть факультет: " + studentDto.getFaculty());
        }

        Mono<StudentDto> response = webClient.post()
                .uri("http://localhost:3456/assign_faculty")
                .bodyValue(studentDto)
                .retrieve()
                .bodyToMono(StudentDto.class);

        StudentDto result = response.block();

        if (result != null) {
            studentRepository.save(StudentMapper.dtoToEntity(result));
        }

        return result;
    }

    // Использование RestTemplate
//    @Override
//    public StudentDto assignFaculty(StudentDto studentDto) {
//        if (studentDto.getFaculty() != null) {
//            throw new FacultyAlreadyAssignedException("У студента уже есть факультет: " + studentDto.getFaculty());
//        }
//        StudentDto result = restTemplate.postForObject(
//                "http://localhost:3456/assign_faculty",
//                studentDto,
//                StudentDto.class,
//                studentDto
//        );
//        studentRepository.save(StudentMapper.dtoToEntity(result));
//        return result;
//    }
}
