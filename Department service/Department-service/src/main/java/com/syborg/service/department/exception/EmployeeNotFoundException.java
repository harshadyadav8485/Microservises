package com.syborg.service.department.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
      super(message);
    }
}
