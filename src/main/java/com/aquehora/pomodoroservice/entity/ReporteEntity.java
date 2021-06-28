package com.aquehora.pomodoroservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ReportesPomodoro")
@Entity
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String notaId;
    @Column(name = "ACTIVIDAD")
    private String NombreNota;
    @Column(name = "VECES DESCANSO")
    private Integer VecesBreak;
    @Column(name = "VECES TRABAJO")
    private Integer VecesWork;
    @Column(name = "TIEMPO DESCANSO")
    private Double TiempoBreak;
    @Column(name = "TIEMPO TRABAJO")
    private Double TiempoWork;
}
