package com.horax.timeManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan({ "com.horax.timeManagement" })
public class MainConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}