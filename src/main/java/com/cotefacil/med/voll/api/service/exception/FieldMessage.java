package com.cotefacil.med.voll.api.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FieldMessage {

    private String fieldName;
    private String fieldMessage;
}
