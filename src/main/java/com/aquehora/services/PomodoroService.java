package com.aquehora.services;

import com.aquehora.DTO.CreatePomodoroDto;
import com.aquehora.DTO.PomodoroDto;
import com.aquehora.exceptions.AqueHoraExceptions;

public interface PomodoroService {
    PomodoroDto createPomodoro(CreatePomodoroDto createPomodoroDto) throws AqueHoraExceptions;

}
