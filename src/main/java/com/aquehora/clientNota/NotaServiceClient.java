package com.aquehora.clientNota;

import com.aquehora.DTO.NotaDto;
import com.aquehora.config.NotaServiceConfig;
import com.aquehora.responses.AqueHoraResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotaServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private NotaServiceConfig notaServiceConfig;

    @Autowired
    private ObjectMapper objectMapper;

    public NotaServiceClient (RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public NotaDto findNotaById(String notaId){
        AqueHoraResponse response =restTemplate.getForObject(notaServiceConfig.getNotaServiceUrl()+"/{notaId}"
                ,AqueHoraResponse.class,notaId);

        NotaDto nota = objectMapper.convertValue(response.getData(), new TypeReference<NotaDto>() {});
        return nota;
    }
}