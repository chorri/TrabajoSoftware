package com.gestordenotas.demo.services;

import com.gestordenotas.demo.DTO.CreateUsuarioDto;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioById(Long usuarioId) throws AqueHoraExceptions; // SI hay error recurre al AqueHoraExceptions
    List<UsuarioDto> getUsuarios() throws  AqueHoraExceptions;
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  AqueHoraExceptions;
    int setupdateUser(String contrasena,Long usuarioId) throws  AqueHoraExceptions;
    int setUpdateUserCorreo(String correo, Long usuarioId) throws AqueHoraExceptions;
    /*int LoginAccess(String usuario, String contrasena) throws  AqueHoraExceptions;*/
    UsuarioDto LoginAcess(String usuario,String contrasena) throws  AqueHoraExceptions;
}