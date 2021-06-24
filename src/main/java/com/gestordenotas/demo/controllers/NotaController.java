package com.gestordenotas.demo.controllers;

import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.NotaRequest;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.converters.NotaConverter;
import com.gestordenotas.demo.entities.Nota;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.responses.AqueHoraResponse;
import com.gestordenotas.demo.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/gestordenotas/demo")
public class NotaController {
    @Autowired
    private NotaService notaService;
    //@Autowired
    //NotaConverter notaConverter;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/notas")
    public AqueHoraResponse<NotaDto> createNota(NotaRequest notaRequest, @RequestBody CreateNotaDto createNotaDto)
           throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,notaRequest));
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
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/nota/updatename")
    public int updateNotaName(@RequestBody String name_nota, Long noteId) {
        try {
            return notaService.setUpdateNameNota(name_nota, noteId);
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/nota/updatedescription")
    public int updateNotaDescription(@RequestBody String contenido, Long noteId) {
        try {
            return notaService.setUpdateDescriptionNota(contenido, noteId);
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotebyuser")
    public AqueHoraResponse<List<NotaDto>> getNotesByUserID(NotaRequest usuarioId)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getNotesUser(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/nota/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            notaService.DeleteNote(noteId);
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnoteByImport")
    public AqueHoraResponse<List<NotaDto>> getNotaByImportancia(Integer importancia,NotaRequest usuarioID)throws
            AqueHoraExceptions {
        return  new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByImportancia(importancia,usuarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnoteFC")
    public AqueHoraResponse<List<NotaDto>> getNotaByNamebyFechaCreate(Date fecha_Creacion)throws
            AqueHoraExceptions {
        return  new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaCreacion(fecha_Creacion));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotes")
    public List<NotaDto> getNotes(){
        return notaService.getAllNotes();
    }
}
