package com.adrian.t2ej3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcCongif implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/palmares").setViewName("team");
        registry.addViewController("/galeria").setViewName("photos");
        registry.addViewController("/enlaces").setViewName("external_links");
    }
}
