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
public class CalendarioServiceImpl implements CalendarioService {
    @Autowired
    private UsuarioServiceIpml usuarioServiceIpml;

    @Autowired
    private CalendarioRepository calendarioRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto) throws AqueHoraExceptions{
        Calendario calendario = new Calendario();
        calendario.setName_calendario(createCalendarioDto.getName_calendario());

        //Por ahora usuario Fijo para testear
        Usuario currentUsuario = new Usuario();
        try{
            currentUsuario = usuarioServiceIpml.getUsuarioEntity((long)9);
        }
        catch (Exception ex){
        //Checkear si es error correcto
        throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }
        calendario.setUsuario(currentUsuario);

        try{
            calendario = calendarioRepository.save(calendario);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getCalendarioEntity(calendario.getId()), CalendarioDto.class);
    }
    @Override
    public CalendarioDto updateCalendario(CalendarioDto calendarioDto) throws AqueHoraExceptions {
        return null;
    }
    public Calendario getCalendarioEntity(Long CalendarioId) throws AqueHoraExceptions{
        return calendarioRepository.findById(CalendarioId).orElseThrow(()->new NotFoundException("NotFound-4040", "Calendario-NotFound-404"));
    }

}
