package com.jorgehernandezramirez.spring.springboot.h2.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jorgehernandezramirez.spring.springboot.h2.dao.repository")
@EntityScan(basePackages = "com.jorgehernandezramirez.spring.springboot.h2.dao.entity")
public class JpaConfiguration {

    @Bean
    public ServletRegistrationBean h2servletRegistration(){
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
