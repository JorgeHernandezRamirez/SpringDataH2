package com.jorgehernandezramirez.spring.springboot.h2.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    @Bean
    public Mapper buildMapper(){
        return new DozerBeanMapper();
    }
}
