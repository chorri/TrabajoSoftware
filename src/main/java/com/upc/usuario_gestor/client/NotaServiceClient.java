package com.upc.usuario_gestor.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.usuario_gestor.DTO.NotaDTO;
import com.upc.usuario_gestor.config.NotaServiceConfig;
import com.upc.usuario_gestor.entities.Usuario;
import com.upc.usuario_gestor.responses.UsuarioGestorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class NotaServiceClient
{
    private RestTemplate restTemplate;
    @Autowired
    private NotaServiceConfig notaServiceConfig;
    private Usuario usuario;
    @Autowired
    private ObjectMapper objectMapper;

    public NotaServiceClient (RestTemplateBuilder builder){restTemplate=builder.build();};
    public List<NotaDTO> getNotasxUser(String user_ID)
    {
        UsuarioGestorResponse response=restTemplate.getForObject(notaServiceConfig.getNotaserviceurl()+"{user_ID}",UsuarioGestorResponse.class,user_ID);
        List<NotaDTO> list=objectMapper.convertValue(response.getData(), new TypeReference<List<NotaDTO>>(){});
        return list;
    }

}
