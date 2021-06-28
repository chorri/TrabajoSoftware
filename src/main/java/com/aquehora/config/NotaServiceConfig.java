package com.aquehora.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class NotaServiceConfig {

    @Value("${notaservice.url}")
    private String notaServiceUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}