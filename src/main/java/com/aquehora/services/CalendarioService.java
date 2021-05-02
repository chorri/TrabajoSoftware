package com.aquehora.services;

import com.aquehora.DTO.CalendarioDto;
import com.aquehora.DTO.CreateCalendarioDto;
import com.aquehora.exceptions.AqueHoraExceptions;

public interface CalendarioService {
    CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto) throws AqueHoraExceptions;
}
