package com.example.mockapi.controller;

import com.example.mockapi.model.ApiResponse;
import com.example.mockapi.model.GradeData;
import com.example.mockapi.service.GradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link GradeController}.
 */
public class GradeControllerTest {

    @Mock
    private GradeService gradeService;

    private GradeController gradeController;

    /**
     * Initializes mocks and controller before each test.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        gradeController = new GradeController(gradeService);
    }

    /**
     * Tests the {@link GradeController#getGrade()} method with mock service.
     */
    @Test
    public void testGetGrade() {
        GradeData gradeData = new GradeData();
        gradeData.setGrade(92);
        gradeData.setGrade_expected("A");

        ApiResponse<GradeData> mockResponse = new ApiResponse<>(200, "Test success", gradeData);

        when(gradeService.getGradeData()).thenReturn(mockResponse);

        ApiResponse<GradeData> response = gradeController.getGrade();

        assertEquals(200, response.getStatus());
        assertEquals("Test success", response.getMessage());
        assertNotNull(response.getData());
        assertEquals(92, response.getData().getGrade());
        assertEquals("A", response.getData().getGrade_expected());

        verify(gradeService, times(1)).getGradeData();
    }
}
