package com.aquehora.services;

import com.aquehora.DTO.NotaDto;
import com.aquehora.DTO.CreateNotaDto;
import com.aquehora.exceptions.AqueHoraExceptions;

public interface NotaService {

    NotaDto createNota(CreateNotaDto createNotaDto) throws AqueHoraExceptions;
    NotaDto updateNota(NotaDto notaDto) throws AqueHoraExceptions;
}
