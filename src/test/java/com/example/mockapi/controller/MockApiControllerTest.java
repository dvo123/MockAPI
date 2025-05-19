package com.example.mockapi.controller;

import com.example.mockapi.model.GradeData;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link MockApiController}.
 */
public class MockApiControllerTest {

    /**
     * Tests that the controller processes grade data and returns OK status.
     */
    @Test
    public void testProcessGrade() {
        MockApiController controller = new MockApiController();
        GradeData gradeData = new GradeData();
        gradeData.setGrade(88);
        gradeData.setGrade_id("G456");

        ResponseEntity<Void> response = controller.processGrade(gradeData);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Tests that retrieving grade data returns NOT_FOUND if no data was set.
     */
    @Test
    public void testGetStoredGradeWithNoData() {
        MockApiController controller = new MockApiController();

        ResponseEntity<GradeData> response = controller.getStoredGrade();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    /**
     * Tests that retrieving grade data returns the correct data after storing.
     */
    @Test
    public void testGetStoredGradeWithData() {
        MockApiController controller = new MockApiController();
        GradeData gradeData = new GradeData();
        gradeData.setGrade(75);
        gradeData.setGrade_id("G789");

        controller.processGrade(gradeData);
        ResponseEntity<GradeData> response = controller.getStoredGrade();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(75, response.getBody().getGrade());
        assertEquals("G789", response.getBody().getGrade_id());
    }
}
