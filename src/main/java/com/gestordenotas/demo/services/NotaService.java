package com.gestordenotas.demo.services;

import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.DTO.NotaRequest;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;

import java.util.Date;
import java.util.List;

public interface NotaService {


    NotaDto createNota(CreateNotaDto createNotaDto,NotaRequest notaRequest)throws AqueHoraExceptions;
    int setUpdateNameNota(String name_nota,Long note_id) throws  AqueHoraExceptions;
    int setUpdateDescriptionNota(String contenido,Long note_id) throws  AqueHoraExceptions;
    List<NotaDto> getNotesUser(NotaRequest notaRequest) throws AqueHoraExceptions;

    void DeleteNote(Long noteId) throws AqueHoraExceptions;
    List<NotaDto> getAllNotes();
    List<NotaDto> getNotasByImportancia(Integer importancia,NotaRequest notaRequest) throws  AqueHoraExceptions;

    List<NotaDto> getNotasByFechaCreacion(Date fecha_Creacion) throws  AqueHoraExceptions;

}
