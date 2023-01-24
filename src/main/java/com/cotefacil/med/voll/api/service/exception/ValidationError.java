package com.cotefacil.med.voll.api.service.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public void addErrors(String fieldName, String fieldMessage) {
        errors.add(new FieldMessage(fieldName, fieldMessage));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
}
