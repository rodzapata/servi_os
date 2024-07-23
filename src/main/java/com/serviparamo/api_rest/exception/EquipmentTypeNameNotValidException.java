package com.serviparamo.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Nombre del tipo de equipo ya se encuentra registrado")
public class EquipmentTypeNameNotValidException extends RuntimeException {

}
