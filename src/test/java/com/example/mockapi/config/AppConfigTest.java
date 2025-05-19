package com.example.mockapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link AppConfig} class.
 */
public class AppConfigTest {

    /**
     * Tests that the RestTemplate bean is not null.
     */
    @Test
    public void testRestTemplateBean() {
        AppConfig appConfig = new AppConfig();
        RestTemplate restTemplate = appConfig.restTemplate();

        assertNotNull(restTemplate);
    }

    /**
     * Tests that the mock API URL bean returns the expected value.
     */
    @Test
    public void testMockApiUrlBean() {
        AppConfig appConfig = new AppConfig();
        String mockApiUrl = appConfig.mockApiUrl();

        assertEquals("http://localhost:8080/api/mock/grade", mockApiUrl);
    }
}
