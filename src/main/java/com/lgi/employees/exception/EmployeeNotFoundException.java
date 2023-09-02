package com.lgi.employees.exception;


/**
 * The Employee class contains the exception details.
 *
 * @author Kalpana Pochareddy
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
