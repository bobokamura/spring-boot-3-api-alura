package com.cotefacil.med.voll.api.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomError {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;
}
