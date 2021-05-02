package com.aquehora.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto
{
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
}
