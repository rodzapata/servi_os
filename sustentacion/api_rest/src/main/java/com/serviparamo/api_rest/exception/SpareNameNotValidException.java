package com.serviparamo.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "nombre del repuesto ya se encuentra registrado")
public class SpareNameNotValidException extends RuntimeException {

}
