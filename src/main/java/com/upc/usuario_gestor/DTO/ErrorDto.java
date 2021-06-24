package com.upc.usuario_gestor.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Esta clase representa los valores que solicitan el ERRORDTO")
public class ErrorDto
{
    private String name;
    @ApiModelProperty(notes="Identificador del error",position = 0)
    private String value;

}
