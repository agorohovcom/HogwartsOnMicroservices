package com.agorohov.hgwrts.studentmanagement.error;

import java.sql.Timestamp;

public class ErrorMessage {

    private Timestamp time;
    private String message;

    public ErrorMessage(Timestamp time, String message) {
        this.time = time;
        this.message = message;
    }

    public ErrorMessage() {
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
