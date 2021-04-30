package com.aquehora.services;

import com.aquehora.DTO.CreateUsuarioDto;
import com.aquehora.DTO.UsuarioDto;
import com.aquehora.exceptions.AqueHoraExceptions;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioById(Long usuarioId) throws AqueHoraExceptions; // SI hay error recurre al whattimeExceptions
    List<UsuarioDto> getUsuarios() throws  AqueHoraExceptions;
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  AqueHoraExceptions;
}
