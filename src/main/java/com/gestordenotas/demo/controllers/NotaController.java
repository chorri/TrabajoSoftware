package com.gestordenotas.demo.controllers;

import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.responses.AqueHoraResponse;
import com.gestordenotas.demo.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/gestordenotas/demo")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/notas")
    public AqueHoraResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto,long usuarioId)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updatenota")
    public AqueHoraResponse<NotaDto> updateNota(@RequestBody NotaDto notaDto) throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to update Nota",String.valueOf(HttpStatus.OK),"Ok",
                                       notaService.updateNota(notaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletenota")
    public void deleteNota(Long notaId)
    {
        try {
            notaService.deleteNota(notaId);
        } catch (AqueHoraExceptions NotaGestorExceptions) {
            NotaGestorExceptions.printStackTrace();
        }
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
