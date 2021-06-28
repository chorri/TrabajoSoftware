package com.aquehora.pomodoroservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reporte {
    private String notaId;
    private String NombreNota;
    private Integer VecesBreak;
    private Integer VecesWork;
    private Double TiempoBreak;
    private Double TiempoWork;
    //Lista de intervalos
}
