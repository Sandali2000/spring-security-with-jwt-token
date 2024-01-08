package com.trash2cashbackend.trash2cashbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    // Define HTTP methods
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";

    // Configure CORS for the application
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow cross-origin requests from any origin, allowing specific HTTP methods and headers
                registry.addMapping("/**")
                        .allowedMethods(GET, POST, PUT, DELETE) // Allow specified HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowedOriginPatterns("*") // Allow requests from any origin
                        .allowCredentials(true); // Allow sending credentials like cookies, authorization headers
            }
        };
    }
}
