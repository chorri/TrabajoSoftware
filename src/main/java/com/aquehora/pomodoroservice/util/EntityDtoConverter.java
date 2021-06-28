package com.aquehora.pomodoroservice.util;

import com.aquehora.pomodoroservice.dto.Reporte;
import com.aquehora.pomodoroservice.entity.ReporteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    private ModelMapper mm;
    @Autowired
    public EntityDtoConverter(ModelMapper mm){
        this.mm=mm;
    }
    public Reporte convertEntityToDto(ReporteEntity repEnt){
        return mm.map(repEnt , Reporte.class);
    }
}
