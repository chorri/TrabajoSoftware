package com.aquehora.services.impl;

import com.aquehora.DTO.CalendarioDto;
import com.aquehora.DTO.CreateCalendarioDto;
import com.aquehora.entities.Calendario;
import com.aquehora.entities.Usuario;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.exceptions.NotFoundException;
import com.aquehora.exceptions.InternalServerErrorException;
import com.aquehora.services.CalendarioService;
import com.aquehora.repositories.CalendarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CalendarioServiceImpl {
    @Autowired
    private UsuarioServiceIpml usuarioServiceIpml;


}
