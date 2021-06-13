package com.gestordenotas.demo.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotaDto {
    private Long id;
    private String name_nota;
    private Integer importancia;
    private String contenido;
    private LocalDateTime fecha_creacion;
}
