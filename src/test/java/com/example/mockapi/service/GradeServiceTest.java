package com.example.mockapi.service;

import com.example.mockapi.model.ApiResponse;
import com.example.mockapi.model.GradeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link GradeService}.
 */
@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GradeService gradeService;

    private final String mockApiUrl = "http://localhost:8080/api/mock/grade";

    /**
     * Initializes the service with the mocked RestTemplate.
     */
    @BeforeEach
    void setUp() {
        gradeService = new GradeService(restTemplate, mockApiUrl);
    }

    /**
     * Tests a successful grade fetch scenario.
     */
    @Test
    void testGetGradeData_success() {
        GradeData mockGrade = new GradeData();
        mockGrade.setGrade(90);
        mockGrade.setGrade_msg("Excellent");

        ResponseEntity<GradeData> response = new ResponseEntity<>(mockGrade, HttpStatus.OK);
        when(restTemplate.getForEntity(mockApiUrl, GradeData.class)).thenReturn(response);

        ApiResponse<GradeData> result = gradeService.getGradeData();

        assertEquals(200, result.getStatus());
        assertEquals("Grade retrieved successfully", result.getMessage());
        assertNotNull(result.getData());
        assertEquals(90, result.getData().getGrade());
    }

    /**
     * Tests case where API returns OK but body is null.
     */
    @Test
    void testGetGradeData_nullBody() {
        ResponseEntity<GradeData> response = new ResponseEntity<>(null, HttpStatus.OK);
        when(restTemplate.getForEntity(mockApiUrl, GradeData.class)).thenReturn(response);

        ApiResponse<GradeData> result = gradeService.getGradeData();

        assertEquals(200, result.getStatus());
        assertEquals("No grade data found", result.getMessage());
        assertNull(result.getData());
    }

    /**
     * Tests handling of an exception during API call.
     */
    @Test
    void testGetGradeData_error() {
        when(restTemplate.getForEntity(mockApiUrl, GradeData.class))
                .thenThrow(new RuntimeException("API error"));

        ApiResponse<GradeData> result = gradeService.getGradeData();

        assertEquals(500, result.getStatus());
        assertTrue(result.getMessage().contains("Failed to fetch grade data"));
        assertNull(result.getData());
    }

    /**
     * Tests behavior when API responds with a non-OK status.
     */
    @Test
    void testGetGradeData_nonOkStatus() {
        ResponseEntity<GradeData> response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(restTemplate.getForEntity(mockApiUrl, GradeData.class)).thenReturn(response);

        ApiResponse<GradeData> result = gradeService.getGradeData();

        assertEquals(404, result.getStatus());
        assertEquals("No grade data found", result.getMessage());
        assertNull(result.getData());
    }
}
