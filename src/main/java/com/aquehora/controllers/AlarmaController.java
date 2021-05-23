package com.aquehora.controllers;

import com.aquehora.DTO.AlarmaDto;
import com.aquehora.DTO.CreateAlarma;
import com.aquehora.exceptions.AqueHoraExceptions;
import com.aquehora.responses.AqueHoraResponse;
import com.aquehora.services.AlarmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraAlarma")
public class AlarmaController {
    @Autowired
    private AlarmaService ObjAS;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/alarmas")
    public AqueHoraResponse<AlarmaDto> createAlarma(@RequestBody CreateAlarma caDTO)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to create Alarma",String.valueOf(HttpStatus.OK),"Ok",
                ObjAS.createAlarma(caDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping

    public AqueHoraResponse<AlarmaDto> updateAlarma(@RequestBody AlarmaDto aDTO)
            throws AqueHoraExceptions {
        return new AqueHoraResponse<>("Succes to update Alarma",String.valueOf(HttpStatus.OK),"Ok",
                ObjAS.updateAlarma(aDTO));
    }



}
