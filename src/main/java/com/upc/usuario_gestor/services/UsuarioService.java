package com.upc.usuario_gestor.services;

import com.upc.usuario_gestor.DTO.CreateUsuarioDto;
import com.upc.usuario_gestor.DTO.UsuarioDto;
import com.upc.usuario_gestor.entities.Usuario;
import com.upc.usuario_gestor.exceptions.UsuarioGestorExceptions;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioById(Long usuarioId) throws UsuarioGestorExceptions; // SI hay error recurre al whattimeExceptions
    List<UsuarioDto> getUsuarios() throws  UsuarioGestorExceptions;
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  UsuarioGestorExceptions;
    int setupdateUserPassword(String contrasena,Long usuarioId) throws  UsuarioGestorExceptions;
    int setUpdateUserCorreo(String correo, Long usuarioId) throws UsuarioGestorExceptions;
    UsuarioDto LoginAcess(String usuario,String contrasena) throws  UsuarioGestorExceptions;
    void deleteUser(Long userid) throws UsuarioGestorExceptions;
}
