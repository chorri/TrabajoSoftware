package com.aquehora.pomodoroservice.dto;

import lombok.Getter;
import lombok.Setter;

//Para hacer la conexion con el microservicio nota
@Getter
@Setter
public class NotaDto {
    private String idNota;
    private String NombreNota;
}
