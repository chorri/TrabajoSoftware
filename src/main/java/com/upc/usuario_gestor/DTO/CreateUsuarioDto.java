package com.upc.usuario_gestor.DTO;

import lombok.Getter;
import lombok.Setter;

//Me guie de la clase pero creo que esto es aparte adicional,se acloparia mejor Nota(Lista)
@Getter
@Setter
public class CreateUsuarioDto
{
    private String name;
    private String correo;
    private String password;
}
