package com.example.mockapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class to define application-wide beans.
 */
@Configuration
public class AppConfig {

    private final String mockApiUrl = "http://localhost:8080/api/mock/grade";

    /**
     * Creates a {@link RestTemplate} bean used for HTTP requests.
     *
     * @return a new RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Provides the mock API URL as a bean.
     *
     * @return the mock API URL string
     */
    @Bean
    public String mockApiUrl() {
        return mockApiUrl;
    }
}
