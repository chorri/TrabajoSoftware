package com.upc.usuario_gestor.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ApiModel(description = "Esta clase representa los datos solicitados para una Nota")
public class NotaDTO
{
    private Long id;
    @ApiModelProperty(notes="Nombre de la Nota",example ="Realizar Proyecto",position = 0)
    private String name_nota;
    @ApiModelProperty(notes="Nivel de Importancia que  tendra cada nota",example ="1,2,3",required = true,position = 1)
    private Integer importancia;
    @ApiModelProperty(notes="Contenido u información que le gustaria guardar",example ="Tengo que hacer mi proyecto",position = 2)
    private String contenido;
    @ApiModelProperty(notes="Fecha de Creación de la nota ",position = 3)
    private LocalDateTime fecha_creacion;
    @ApiModelProperty(notes="Identificador del Usuario que crea esa nota",position = 4)
    private String usuarioid;
}
