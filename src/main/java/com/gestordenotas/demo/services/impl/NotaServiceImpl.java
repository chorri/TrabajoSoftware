package com.gestordenotas.demo.services.impl;

import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.DTO.NotaRequest;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.clientUser.UsuarioServiceClient;
import com.gestordenotas.demo.entities.Nota;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.exceptions.InternalServerErrorException;
import com.gestordenotas.demo.exceptions.NotFoundException;
import com.gestordenotas.demo.repositories.NotaRepository;
import com.gestordenotas.demo.services.NotaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
//import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UsuarioServiceClient usuarioServiceClient;

    @Override
    public NotaDto createNota(CreateNotaDto createNotaDto,NotaRequest notaRequest) throws AqueHoraExceptions
    {
        UsuarioDto usuario=usuarioServiceClient.findUserxID(notaRequest.getUserId());
        log.info(usuario.toString());
        Nota nota = new Nota();
        nota.setName_nota(createNotaDto.getName_nota());
        nota.setImportancia(createNotaDto.getImportancia());
        nota.setContenido(createNotaDto.getContenido());
        nota.setFecha_creacion(createNotaDto.getFecha_creacion());

        //Por ahora usuario Fijo para testear

        //Usuario currentUsuario = new Usuario();
        try{
            //currentUsuario = usuarioServiceIpml.getUsuarioEntity(usuario.getId());
            nota.setUsuarioid(usuario.getId().toString());
            try{
                nota=notaRepository.save(nota);
            } catch (Exception ex) {
                throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
            }
        } catch (Exception ex){
            //Checkear si es error correcto
            throw new NotFoundException("Usuario Error","Usuario Error");
        }

        return modelMapper.map(getNotaEntity(nota.getId()),NotaDto.class);
    }

    @Override
    public int setUpdateNameNota(String name_nota, Long note_id) throws AqueHoraExceptions {
        return notaRepository.setUpdateNoteName(name_nota,note_id);
    }

    @Override
    public int setUpdateDescriptionNota(String contenido, Long note_id) throws AqueHoraExceptions {
        return notaRepository.updateDescriptionNota(contenido,note_id);
    }

    @Override
    public List<NotaDto> getNotesUser(NotaRequest notaRequest) throws AqueHoraExceptions
    {
        UsuarioDto usuario=usuarioServiceClient.findUserxID(notaRequest.getUserId());
        List<Nota> noteEntity=notaRepository.findNotas(usuario.getId().toString());
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());

    }

    @Override
    public void DeleteNote(Long noteId) throws AqueHoraExceptions
    {
        notaRepository.deleteNote(noteId);
    }

    @Override
    public List<NotaDto> getAllNotes() {
        List<Nota> notaEntity=notaRepository.findAll();
        return notaEntity.stream().map(nota -> modelMapper.map(nota,NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NotaDto> getNotasByImportancia(Integer importancia, NotaRequest notaRequest) throws AqueHoraExceptions
    {
        UsuarioDto usuario=usuarioServiceClient.findUserxID(notaRequest.getUserId());
        List<Nota> noteEntity= notaRepository.findTodasNotasImportancia(importancia,usuario.getId().toString());
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NotaDto> getNotasByFechaCreacion(Date fecha_Creacion) throws AqueHoraExceptions {
        List<Nota> noteEntity= notaRepository.findNotasFechaCreacion(fecha_Creacion);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    public Nota getNotaEntity(Long notaId) throws AqueHoraExceptions {
        return notaRepository.findById(notaId).orElseThrow(() -> new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }

}
