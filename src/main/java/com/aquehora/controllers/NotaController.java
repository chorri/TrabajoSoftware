package com.aquehora.controllers;

import com.aquehora.DTO.CreateNotaDto;
import com.aquehora.DTO.NotaDto;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.responses.AqueHoraResponse;
import com.aquehora.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraNota")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/notas")
    public AqueHoraResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto) throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                                        notaService.createNota(createNotaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public AqueHoraResponse<NotaDto> updateNota(@RequestBody NotaDto notaDto) throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to update Nota",String.valueOf(HttpStatus.OK),"Ok",
                                       notaService.updateNota(notaDto));
    }

    /*
        @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public AqueHoraResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

     */
}
