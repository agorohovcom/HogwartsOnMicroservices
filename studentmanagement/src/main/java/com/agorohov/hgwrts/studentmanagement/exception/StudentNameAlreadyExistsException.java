package com.agorohov.hgwrts.studentmanagement.exception;

public class StudentNameAlreadyExistsException extends RuntimeException {

    public StudentNameAlreadyExistsException() {
        super();
    }

    public StudentNameAlreadyExistsException(String message) {
        super(message);
    }

    public StudentNameAlreadyExistsException(String message,
                                             Throwable cause) {
        super(message, cause);
    }

    public StudentNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected StudentNameAlreadyExistsException(String message,
                                                Throwable cause,
                                                boolean enableSuppression,
                                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
