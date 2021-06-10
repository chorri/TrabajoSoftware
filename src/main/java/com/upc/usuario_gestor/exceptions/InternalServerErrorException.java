package com.upc.usuario_gestor.exceptions;


import com.upc.usuario_gestor.DTO.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends UsuarioGestorExceptions
{
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
