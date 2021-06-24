package com.gestordenotas.demo.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class UsuarioServiceConfig
{
    @Value("${usuarioservice.url}")
    private String usuarioServiceUrl;

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
