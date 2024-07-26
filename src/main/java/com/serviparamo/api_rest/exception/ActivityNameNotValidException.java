package com.serviparamo.api_rest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "nombre de la Actividad ya se encuentra registrado")
public class ActivityNameNotValidException extends RuntimeException {

}
