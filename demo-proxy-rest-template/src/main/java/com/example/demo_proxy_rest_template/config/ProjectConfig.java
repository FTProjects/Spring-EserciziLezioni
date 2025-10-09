package com.example.demo_proxy_rest_template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {

    // forniamo un bean RestTemplate al context
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
