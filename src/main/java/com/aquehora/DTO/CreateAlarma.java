package com.aquehora.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAlarma {
    private String nombre;
    private Integer duracion;
    private LocalDateTime fecha_creacion;
    private String descripcion;
}
