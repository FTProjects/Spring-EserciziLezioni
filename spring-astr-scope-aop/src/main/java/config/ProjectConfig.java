package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"Service", "Repository", "Proxy", "aspect"})
@EnableAspectJAutoProxy // abilita l'AOP cercando lel classi Aspects nel progetto
public class ProjectConfig {

}
