package com.alexdevuwu.avft02ej03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/palmares").setViewName("palmares");
        registry.addViewController("/galeria-fotos").setViewName("galeria-fotos");
        registry.addViewController("/enlaces-externos").setViewName("enlaces-externos");
    }
}