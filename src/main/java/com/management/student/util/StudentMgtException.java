package com.management.student.util;

import java.util.LinkedList;

public class StudentMgtException extends RuntimeException {
    private LinkedList errors;

    public StudentMgtException(String message) {
        super(message);
    }

    public StudentMgtException(LinkedList errors) {
        super();
        this.errors = errors;
    }

    public StudentMgtException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkedList getErrors() {
        return errors;
    }

    public void setErrors(LinkedList errors) {
        this.errors = errors;
    }
}
