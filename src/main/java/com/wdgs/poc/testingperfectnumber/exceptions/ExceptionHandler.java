package com.wdgs.poc.testingperfectnumber.exceptions;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;



@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> Error404() {
        return ResponseEntity.notFound().build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> NotValidMethod(MethodArgumentNotValidException ex) {
        List<FieldError> fields = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(fields.stream().map(DataErrorvalidation::new).toList());
    }


    public record DataErrorvalidation(String colunm, String message) {
        DataErrorvalidation(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }

    }


}