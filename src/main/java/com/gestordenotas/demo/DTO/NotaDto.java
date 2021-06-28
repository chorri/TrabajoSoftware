package com.gestordenotas.demo.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para crear una Nota")
public class NotaDto {
    @ApiModelProperty(notes="Id de la nota",example ="1",required = true,position = 0)
    private Long id;
    @ApiModelProperty(notes="Nombre de la nota",example ="Cosas para hacer antes del examen final",required = true,position = 1)
    private String name_nota;
    @ApiModelProperty(notes="Importancia de la nota",example ="3",required = true,position = 2)
    private Integer importancia;
    @ApiModelProperty(notes="Contenido de la nota",example ="Estudiar un montón toda la semana",required = true,position = 3)
    private String contenido;
    @ApiModelProperty(notes="Fecha de creación",example ="2021-06-27T21:51:29.682Z",required = true,position = 4)
    private LocalDateTime fecha_creacion;
    @ApiModelProperty(notes="Id del usuario dueño de la nota",example ="1",required = true,position = 5)
    private String usuarioid;
    @ApiModelProperty(notes="Id del usuario invitado a la nota",example ="1",required = false,position = 6)
    private String usuarioIdInvitado;

}
