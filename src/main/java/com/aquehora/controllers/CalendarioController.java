package com.aquehora.controllers;

import com.aquehora.DTO.CreateCalendarioDto;
import com.aquehora.DTO.CalendarioDto;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.responses.AqueHoraResponse;
import com.aquehora.services.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraCalendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calendario")
    public AqueHoraResponse<CalendarioDto> createCalendario(@RequestBody CreateCalendarioDto createCalendarioDto)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                calendarioService.createCalendario(createCalendarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public AqueHoraResponse<CalendarioDto> updateCalendario(@RequestBody CalendarioDto calendarioDto)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to update Calendario",String.valueOf(HttpStatus.OK),"Ok",
                calendarioService.updateCalendario(calendarioDto));
    }
}
