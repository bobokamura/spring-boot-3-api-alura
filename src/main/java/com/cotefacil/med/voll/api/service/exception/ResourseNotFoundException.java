package com.cotefacil.med.voll.api.service.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(Long id) {
        super("Id: " + id + " not found");
    }
}
