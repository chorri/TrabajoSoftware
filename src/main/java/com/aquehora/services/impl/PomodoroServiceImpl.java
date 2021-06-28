package com.aquehora.services.impl;

import com.aquehora.DTO.*;
import com.aquehora.clientNota.NotaServiceClient;
import com.aquehora.entities.Pomodoro;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.exceptions.InternalServerErrorException;
import com.aquehora.exceptions.NotFoundException;
import com.aquehora.repositories.PomodoroRepository;
import com.aquehora.services.PomodoroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomodoroServiceImpl implements PomodoroService {


    @Autowired
    private PomodoroRepository pomodoroRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private NotaServiceClient notaServiceClient;

    @Override
    public PomodoroDto createPomodoro(CreatePomodoroDto createPomodoroDto) throws AqueHoraExceptions{
        NotaDto nota = notaServiceClient.findNotaById(createPomodoroDto.getNotaId());
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDuracion(createPomodoroDto.getDuracion());
        pomodoro.setName_pomodoro(createPomodoroDto.getName_pomodoro());
        pomodoro.setFecha_creacion(createPomodoroDto.getFecha_creacion());

        try{
            pomodoro.setNotaId(nota.getId().toString());
            try{
                pomodoro=pomodoroRepository.save(pomodoro);
            }catch (Exception ex){
                throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
            }
        } catch (Exception ex){
            throw new NotFoundException("Nota Error","Nota Error");
        }

        return  modelMapper.map(getPomodoroEntity(pomodoro.getId()),PomodoroDto.class);
    }

    public Pomodoro getPomodoroEntity(Long pomodoroId)throws AqueHoraExceptions{
        return pomodoroRepository.findById(pomodoroId).orElseThrow(()->new NotFoundException("NotFound-4040", "Pomodoro-NotFound-404"));
    }
}

