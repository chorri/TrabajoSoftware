package com.gestordenotas.demo.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@ApiModel(description = "Esta clase representa los datos solicitados de un Usuario")
public class UsuarioDto
{
    private Long id;
    @ApiModelProperty(notes="Nombre",example ="Hamill",required = true,position = 0)
    private String nombre;
    @ApiModelProperty(notes="Correo",example ="hamillcavero@gmail.com",required = true,position = 1)
    private String correo;
    @ApiModelProperty(notes="Contraseña",example ="passwordbienlista",required = true,position = 2)
    private String contrasena;
}
