package com.gestordenotas.demo.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class UsuarioDto
{
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
}
