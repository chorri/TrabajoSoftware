package com.aquehora.controllers;

import com.aquehora.DTO.*;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.responses.AqueHoraResponse;
import com.aquehora.services.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraPomodoro")

public class PomodoroController {
    @Autowired
    private PomodoroService pomodoroService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/pomodoros")
    public AqueHoraResponse<PomodoroDto> createPomodoro(@RequestBody CreatePomodoroDto createPomodoro)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                pomodoroService.createPomodoro(createPomodoro));
    }
}
