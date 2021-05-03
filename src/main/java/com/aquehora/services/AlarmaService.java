package com.tp.tp.service;

import com.tp.tp.entity.Alarma;
import com.tp.tp.exception.GeneralServiceException;
import com.tp.tp.exception.NoDataFoundException;
import com.tp.tp.exception.ValidateServiceException;
import com.tp.tp.repository.AlarmaRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class AlarmaService {
    @Autowired // Inyeccion de dependencias
    AlarmaRepository arepository;

    //Metodo para obtener una alarma por id
    public Alarma getAlarmaById(Long alarmaId){
        try{
            log.debug("findById => " + alarmaId);
            Alarma alarma = arepository.findById(alarmaId).
                    orElseThrow(() -> new NoDataFoundException("No existe la alarma"));
            return alarma;

        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);

        }

    }

    //Metodo para agregar una alarma



    //Metodo para eliminar una alarma
    @Transactional
    public void deleteAlarma(Long alarmaId){
        try{
            Alarma alarma = arepository.findById(alarmaId)
                    .orElseThrow(() -> new NoDataFoundException("No existe alarma"));
            arepository.delete(alarma);
        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        } catch (Exception e){
            log.error(e.getMessage(),e);
            throw  new GeneralServiceException(e.getMessage(),e);
        }
    }

    //Metodo para modificar y agregar una alarma
    @Transactional
    public Alarma saveAlarma(Alarma alarma){
        try {
            if (alarma == null){
                Alarma newAlarma = arepository.save(alarma);
                return newAlarma;
            }
            Alarma exitAlarma = arepository.findById(alarma.getId())
                    .orElseThrow(()->new NoDataFoundException("No existe Alarma"));

            exitAlarma.setNombre(alarma.getNombre());
            exitAlarma.setDescripcion(alarma.getDescripcion());
            exitAlarma.setFechaCreacion(alarma.getFechaCreacion());
            exitAlarma.setIdCalendario(alarma.getIdCalendario());
            exitAlarma.setIdNota(alarma.getIdNota());
            return exitAlarma;

        } catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(), e);
            throw e;

        }
    }

}
