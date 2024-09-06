package com.serviparamo.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

/*
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Recurso no encontrado")
public class ResourceNotFoundException extends RuntimeException{
}
*/