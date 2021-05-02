package com.aquehora.services.impl;

import com.aquehora.DTO.NotaDto;
import com.aquehora.DTO.CreateNotaDto;
import com.aquehora.entities.Nota;
import com.aquehora.entities.Usuario;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.exceptions.InternalServerErrorException;
import com.aquehora.exceptions.NotFoundException;
import com.aquehora.repositories.NotaRepository;
import com.aquehora.services.NotaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private UsuarioServiceIpml usuarioServiceIpml;


    @Autowired
    private NotaRepository notaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NotaDto createNota(CreateNotaDto createNotaDto) throws AqueHoraExceptions{
        Nota nota = new Nota();
        nota.setName_nota(createNotaDto.getName_nota());
        nota.setImportancia(createNotaDto.getImportancia());
        nota.setContenido(createNotaDto.getContenido());
        nota.setFecha_creacion(createNotaDto.getFecha_creacion());

        //Por ahora usuario Fijo para testear
        Usuario currentUsuario = new Usuario();
        try{
            currentUsuario = usuarioServiceIpml.getUsuarioEntity((long)9);
        } catch (Exception ex){
            //Checkear si es error correcto
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }
        nota.setUsuario(currentUsuario);

        try{
            nota=notaRepository.save(nota);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getNotaEntity(nota.getId()),NotaDto.class);
    }

    private Nota getNotaEntity(Long notaId) throws AqueHoraExceptions {
        return notaRepository.findById(notaId).orElseThrow(() -> new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }
}
