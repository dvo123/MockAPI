package com.example.mockapi.service;

import com.example.mockapi.model.ApiResponse;
import com.example.mockapi.model.GradeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class responsible for retrieving grade data
 * from a mock API endpoint using RestTemplate.
 */
@Service
public class GradeService {

	  private final RestTemplate restTemplate;
	  private final String mockApiUrl;


    /**
     * Constructs a new GradeService with the provided RestTemplate and mock API URL.
     *
     * @param restTemplate the RestTemplate used for making HTTP requests
     * @param mockApiUrl   the URL of the mock API endpoint
     */
    public GradeService(RestTemplate restTemplate, String mockApiUrl) {
        this.restTemplate = restTemplate;
        this.mockApiUrl = mockApiUrl;
    }

    /**
     * Fetches grade data from the mock API endpoint.
     *
     * @return an ApiResponse containing the grade data if successful,
     *         a message indicating no data if the response body is null,
     *         or an error message if the API call fails.
     */
    public ApiResponse<GradeData> getGradeData() {
        try {
            ResponseEntity<GradeData> mockResponse = restTemplate.getForEntity(mockApiUrl, GradeData.class);

            if (mockResponse.getStatusCode() == HttpStatus.OK && mockResponse.getBody() != null) {
                return new ApiResponse<>(200, "Grade retrieved successfully", mockResponse.getBody());
            } else {
                return new ApiResponse<>(mockResponse.getStatusCode().value(), "No grade data found", null);
            }
        } catch (Exception e) {
            return new ApiResponse<>(500, "Failed to fetch grade data: " + e.getMessage(), null);
        }
    }
}
