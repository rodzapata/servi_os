package com.serviparamo.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cliente no encontrado")
public class CustomerNotFoundException extends RuntimeException{
}

