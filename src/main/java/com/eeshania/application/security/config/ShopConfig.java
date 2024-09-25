package com.eeshania.application.security.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class ShopConfig {
  @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
