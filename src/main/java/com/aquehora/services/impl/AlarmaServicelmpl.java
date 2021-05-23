package com.aquehora.services.impl;

import com.aquehora.DTO.AlarmaDto;
import com.aquehora.DTO.CreateAlarma;
import com.aquehora.entities.Alarma;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.exceptions.NotFoundException;
import com.aquehora.repositories.AlarmaRepository;
import com.aquehora.services.AlarmaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmaServicelmpl implements AlarmaService {
    @Autowired
    private CalendarioServiceImpl csImpl;

    @Autowired
    private AlarmaRepository alRep;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public AlarmaDto createAlarma(CreateAlarma caDto) throws AqueHoraExceptions{
        Alarma al = new Alarma();
        al.setNombre(caDto.getNombre());
        al.setDescripcion(caDto.getDescripcion());
        al.setFechaCreacion(caDto.getFecha_creacion());
        al.setDuracion(caDto.getDuracion());

        return modelMapper.map(getAlarmaEntity(al.getId()), AlarmaDto.class);
    }

    @Override
    public AlarmaDto updateAlarma(AlarmaDto alDto) throws AqueHoraExceptions {
        return null;
    }

    public Alarma getAlarmaEntity(Long CalendarioId) throws AqueHoraExceptions{
        return alRep.findById(CalendarioId).orElseThrow(()->new NotFoundException("NotFound-4040", "Calendario-NotFound-404"));
    }

}
