package com.aquehora.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateUsuarioDto
{
    private String name;
    private String correo;
    private String contrasena;
}
