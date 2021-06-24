package com.upc.usuario_gestor.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NotaDTO
{
    private Long id;
    private String name_nota;
    private Integer importancia;
    private String contenido;
    private LocalDateTime fecha_creacion;
    private String usuarioid;
}
