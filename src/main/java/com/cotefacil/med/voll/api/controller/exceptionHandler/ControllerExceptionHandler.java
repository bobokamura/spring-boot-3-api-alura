package com.cotefacil.med.voll.api.controller.exceptionHandler;

import com.cotefacil.med.voll.api.service.exception.CustomError;
import com.cotefacil.med.voll.api.service.exception.ResourseNotFoundException;
import com.cotefacil.med.voll.api.service.exception.ValidationError;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<CustomError> integrityConstraintViolationException(SQLIntegrityConstraintViolationException e, HttpServletRequest request) {
        CustomError err = new CustomError();
        HttpStatus status = HttpStatus.CONFLICT;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("DEU RUIM " + e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<CustomError> resourseNotFound(ResourseNotFoundException e, HttpServletRequest request) {
        CustomError err = new CustomError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found! " + e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError err = new ValidationError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Unprocessable entity");
        err.setPath(request.getRequestURI());

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            err.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
        });

//        for(FieldError fe : e.getBindingResult().getFieldErrors()) {
//            err.addErrors(fe.getField(), fe.getDefaultMessage());
//        }

        return ResponseEntity.status(status).body(err);
    }
}
