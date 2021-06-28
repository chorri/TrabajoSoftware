package com.aquehora.pomodoroservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@ApiModel(description = "Esta clase representa los datos que seran ingresados por el usuario" +
        "para la configuracion de los pomodoros")
public class ConfigPomodoro {
    @NotBlank
    @NotNull
    @ApiModelProperty(notes = "Id de la nota a la que se le aplicara pomodoros",
            example = "97845124",required = true)
    private String idNota;
    @ApiModelProperty(notes = "Nombre de la nota a la que se le aplicara pomodoros",
            example = "Avanzar Ingenieria de Software",required = false)
    private String NombreNota;
    @ApiModelProperty(notes = "Este atributo indica el inicio de la actividad",
            example = "Tue, 02 Jan 2018 18:07:59 IST",required = true)
    private Date fecInicio;
    @ApiModelProperty(notes = "Este atributo indica el fin de la actividad",
            example = "Tue, 02 Jan 2018 18:07:59 IST",required = true)
    private Date fecFin;
    //lista de intervalos
    @ApiModelProperty(notes = "Este almacena los pomodoros asociados a esta nota o actividad",
    required = true)
    List<Intervalos> pomodoros;
}
