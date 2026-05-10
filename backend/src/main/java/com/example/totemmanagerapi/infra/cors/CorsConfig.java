package com.example.totemmanagerapi.infra.cors;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${app.upload.dir}")
    private String uploadDir;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String path = Paths.get(uploadDir)
                .toAbsolutePath()
                .toUri()
                .toString();

        registry
                .addResourceHandler("/images/**")
                .addResourceLocations(path);
    }
}