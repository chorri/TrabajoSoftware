package com.aquehora.pomodoroservice.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@ApiModel(description = "Esta clase representa el intervalo de tiempo en el que el pomodoro" +
        "trabaja siendo este un break o realizar la actividad dada")
@Getter
@Setter
@AllArgsConstructor
public class Intervalos {
    @ApiModelProperty(notes = "Este atributo indica si el intervalo pertenece a un " +
            "break o a dedicarse a la actividad")
    private Character BorW;
    @ApiModelProperty(notes = "Este atributo indica el inicio del pomodoro",
    example = "07:25:35",required = true)
    private Date fechaInicio;
    @ApiModelProperty(notes = "Este atributo indica el fin del pomodoro",
    example = "07:25:35",required = true)
    private Date fechaFin;
}
