package com.example.mockapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link ApiResponse}.
 */
public class ApiResponseTest {

    /**
     * Tests constructor and field initialization of ApiResponse with GradeData.
     */
    @Test
    public void testApiResponseConstructor() {
        GradeData gradeData = new GradeData();
        gradeData.setGrade(90);

        ApiResponse<GradeData> response = new ApiResponse<>(200, "Success", gradeData);

        assertEquals(200, response.getStatus());
        assertEquals("Success", response.getMessage());
        assertEquals(90, response.getData().getGrade());
    }

    /**
     * Tests getters and setters for ApiResponse.
     */
    @Test
    public void testApiResponseGettersAndSetters() {
        ApiResponse<String> response = new ApiResponse<>();

        response.setStatus(404);
        response.setMessage("Not found");
        response.setData("Test data");

        assertEquals(404, response.getStatus());
        assertEquals("Not found", response.getMessage());
        assertEquals("Test data", response.getData());
    }
}
