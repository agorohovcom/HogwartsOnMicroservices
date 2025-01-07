package com.agorohov.hgwrts.studentmanagement.exception;

public class FacultyAlreadyAssignedException extends RuntimeException {
    public FacultyAlreadyAssignedException() {
    }

    public FacultyAlreadyAssignedException(String message) {
        super(message);
    }

    public FacultyAlreadyAssignedException(String message,
                                           Throwable cause) {
        super(message, cause);
    }

    public FacultyAlreadyAssignedException(Throwable cause) {
        super(cause);
    }

    public FacultyAlreadyAssignedException(String message,
                                           Throwable cause,
                                           boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
