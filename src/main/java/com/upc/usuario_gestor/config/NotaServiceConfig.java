package com.upc.usuario_gestor.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource({"classpath:application.properties"})
public class NotaServiceConfig
{
    @Value("${notaservice.url}")
    private String notaserviceurl;
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
