package com.gestordenotas.demo.controllers;

import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.NotaRequest;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.converters.NotaConverter;
import com.gestordenotas.demo.entities.Nota;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.repositories.NotaRepository;
import com.gestordenotas.demo.responses.AqueHoraResponse;
import com.gestordenotas.demo.services.NotaService;
import io.swagger.annotations.ApiOperation;
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
    @Autowired
    private NotaRepository notaRepository;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Crea una nota usando el nombre de la nota, el contenido, su importancia, fecha de creación y el id del usuario que lo creó")
    @PostMapping("/notas")
    public AqueHoraResponse<NotaDto> createNota(NotaRequest notaRequest, @RequestBody CreateNotaDto createNotaDto)
           throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Success to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,notaRequest));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza el nombre de una nota ya existente, requiere el nuevo nombre de la nota y el id de la nota a cambiar")
    @PutMapping("/nota/updatename")
    public int updateNotaName(@RequestBody String name_nota, Long noteId) {
        try {
            if(notaRepository.existsById(noteId)) {
                return notaService.setUpdateNameNota(name_nota, noteId);
            }

        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza la descripción de una nota ya existente, requiere el nuevo contenido de la nota y el ide de la nota a modificar")
    @PutMapping("/nota/updatedescription")
    public int updateNotaDescription(@RequestBody String contenido, Long noteId) {
        try {
            if(notaRepository.existsById(noteId)) {
                return notaService.setUpdateDescriptionNota(contenido, noteId);
            }
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista que contiene todas las notas de un usuario, se requiere el id del usuario de quien se devolverán las notas")
    @GetMapping("/nota/getnotebyuser")
    public AqueHoraResponse<List<NotaDto>> getNotesByUserID(NotaRequest usuarioId)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getNotesUser(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Borramos una nota, se pide el id de la nota a borrar")
    @DeleteMapping("/nota/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            if(notaRepository.existsById(noteId)) {
                notaService.DeleteNote(noteId);
            }
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Añadimos un usuario amigo a la nota, nos pide el id de la nota y el id del amigo")
    @PutMapping("/nota/updateAmigo")
    public int updateUsuarioInvitadoNota(Long noteId,String usuarioInvitadoId)
    {
        try {
            NotaDto notaDto= notaService.getNotaByID(noteId);
            if(notaRepository.existsNotaByIdAndUsuarioIdInvitadoIsNull(noteId) && !notaDto.getUsuarioid().equals(usuarioInvitadoId)) {
                return notaService.setUpdateUsuarioAmigoById(usuarioInvitadoId,noteId);
            }
        } catch (AqueHoraExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista de notas pertenecientes a un usuario filtradas por su importancia, se pide ingresar la importancia y el Id de usuario")
    @GetMapping("/nota/gnoteByImport")
    public AqueHoraResponse<List<NotaDto>> getNotaByImportancia(Integer importancia,NotaRequest usuarioID)throws
            AqueHoraExceptions {
        return  new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByImportancia(importancia,usuarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista de notas filtradas por su fecha de creación, nos pide una fecha")
    @GetMapping("/nota/gnoteFC")
    public AqueHoraResponse<List<NotaDto>> getNotaByNamebyFechaCreate(Date fecha_Creacion)throws
            AqueHoraExceptions {
        return  new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaCreacion(fecha_Creacion));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una lista que contiene todas las notas")
    @GetMapping("/nota/getnotes")
    public List<NotaDto> getNotes(){
        return notaService.getAllNotes();
    }



}
