package com.upc.usuario_gestor.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos solicitados de un Usuario")
public class UsuarioDto //Cosas que quiero obtener cuando pregunto por un usuario
{

    private Long id;
    @ApiModelProperty(notes="Nombre",example ="Elvis",required = true,position = 0)
    private String nombre;
    @ApiModelProperty(notes="Correo",example ="usuario@gmail.com",required = true,position = 1)
    private String correo;
    @ApiModelProperty(notes="Contraseña",example ="contraseña",required = true,position = 2)
    private String contrasena;
}
