package com.gestordenotas.demo.services;

import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;

public interface NotaService {

    NotaDto createNota(CreateNotaDto createNotaDto) throws AqueHoraExceptions;
    NotaDto updateNota(NotaDto notaDto) throws AqueHoraExceptions;
}
