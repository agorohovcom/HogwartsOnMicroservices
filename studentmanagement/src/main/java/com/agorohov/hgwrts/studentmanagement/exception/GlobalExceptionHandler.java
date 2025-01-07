package com.agorohov.hgwrts.studentmanagement.exception;

import com.agorohov.hgwrts.studentmanagement.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNameAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> studentNameAlreadyExists(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
        errorMessage.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(FacultyAlreadyAssignedException.class)
    public ResponseEntity<ErrorMessage> facultyAlreadyAssigned(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
        errorMessage.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFound(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
        errorMessage.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<ErrorMessage> connectException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
        errorMessage.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
