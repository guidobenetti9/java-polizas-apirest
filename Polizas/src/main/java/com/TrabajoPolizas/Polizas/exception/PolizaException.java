package com.TrabajoPolizas.Polizas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PolizaException extends RuntimeException {

    private final HttpStatus status;
    public PolizaException(final HttpStatus httpStatus) {
        this.status = httpStatus;
    }

    public PolizaException(final HttpStatus httpStatus, final String message) {
        super(message);
        this.status = httpStatus;
    }
}
