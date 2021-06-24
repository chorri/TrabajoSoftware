package com.gestordenotas.demo.clientUser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.config.UsuarioServiceConfig;
import com.gestordenotas.demo.responses.AqueHoraResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;

@Slf4j  //para hacer una Log o trazabilidad de que datos voy obteniendo y eso se imprimiria en la consola.
@Component
public class UsuarioServiceClient
{
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioServiceConfig config;

    @Autowired
    private ObjectMapper objectMapper;
    public UsuarioServiceClient(RestTemplateBuilder builder)
    {
        restTemplate= builder.build();
    }

    public UsuarioDto findUserxID(String user_ID)
    {
        AqueHoraResponse response=restTemplate.getForObject(config.getUsuarioServiceUrl()+"/{usuarioId}",AqueHoraResponse.class,user_ID);

        UsuarioDto usuario=objectMapper.convertValue(response.getData(), new TypeReference<UsuarioDto>() {});
        return usuario;
    }
}
