package com.aquehora.services;

import com.aquehora.DTO.AlarmaDto;
import com.aquehora.DTO.CreateAlarma;
import com.aquehora.exceptions.AqueHoraExceptions;

public interface AlarmaService {
    AlarmaDto createAlarma(CreateAlarma ca) throws AqueHoraExceptions;
    AlarmaDto updateAlarma(AlarmaDto alarmaDto) throws AqueHoraExceptions;
}
