package com.example.demo_proxy_web_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        // builder pattern
        return WebClient.builder().build();
    }
}
