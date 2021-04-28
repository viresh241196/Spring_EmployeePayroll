package com.bridgelabz.employeepayrollspring.exception;

public class EmployeeException extends RuntimeException{
    private final exceptionType type;

    public EmployeeException(exceptionType type,String message) {
        super(message);
        this.type = type;
    }

    public enum exceptionType {
        EMPLOYEE_NOT_FOUND,
    }
}
