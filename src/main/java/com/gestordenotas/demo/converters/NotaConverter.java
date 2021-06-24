package com.gestordenotas.demo.converters;

import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.entities.Nota;
import com.gestordenotas.demo.DTO.NotaDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotaConverter extends AbstractConverter<Nota, NotaDto> {

    @Override
    public NotaDto fromEntity(Nota entity) {
        return null;
    }

    @Override
    public Nota fromDTO(NotaDto dto) {
        return null;
    }

    /*
    @Override
    public NotaDto fromEntity (Nota entity){
        if (entity == null) return null;

        return NotaDto.builder()
                .id(entity.getId())
                .name_nota(entity.getName_nota())
                .importancia(entity.getImportancia())
                .contenido(entity.getContenido())
                .fecha_creacion(entity.getFecha_creacion())
                .build();
    }*/

    public Nota create(CreateNotaDto dto) {
        return Nota.builder()
                .name_nota(dto.getName_nota())
                .importancia(dto.getImportancia())
                .contenido((dto.getContenido()))
                .fecha_creacion(dto.getFecha_creacion())
                .build();
    }

}
