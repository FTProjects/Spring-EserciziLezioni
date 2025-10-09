package com.example.demo_proxy_openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
// abilita il client openfeign scansionando il package dove è incluso il nostro proxy
@EnableFeignClients(basePackages = "com.example.demo_proxy_openfeign.proxy")
public class ProjectConfig {
}
