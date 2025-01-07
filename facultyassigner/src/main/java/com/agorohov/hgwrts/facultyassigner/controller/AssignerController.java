package com.agorohov.hgwrts.facultyassigner.controller;

import com.agorohov.hgwrts.facultyassigner.dto.StudentDto;
import com.agorohov.hgwrts.facultyassigner.service.AssignerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignerController {

    private final AssignerService assignerService;

    public AssignerController(AssignerService assignerService) {
        this.assignerService = assignerService;
    }

    @PostMapping("/assign_faculty")
    public ResponseEntity<StudentDto> assignFaculty(@RequestBody StudentDto studentDto) {
        StudentDto result = assignerService.assignFaculty(studentDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
