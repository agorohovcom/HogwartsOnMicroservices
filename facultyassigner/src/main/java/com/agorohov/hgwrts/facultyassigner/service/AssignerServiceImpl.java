package com.agorohov.hgwrts.facultyassigner.service;

import com.agorohov.hgwrts.facultyassigner.dto.StudentDto;
import com.agorohov.hgwrts.facultyassigner.dto.enums.Faculties;
import org.springframework.stereotype.Service;

@Service
public class AssignerServiceImpl implements AssignerService {

    @Override
    public StudentDto assignFaculty(StudentDto studentDto) {
        String faculty = Faculties.getRandomFaculty().name();
        studentDto.setFaculty(faculty);
        return studentDto;
    }
}
