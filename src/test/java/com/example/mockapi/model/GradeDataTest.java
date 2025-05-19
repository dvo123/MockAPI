package com.example.mockapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link GradeData}.
 */
public class GradeDataTest {

    /**
     * Tests all getters and setters of GradeData.
     */
    @Test
    public void testGradeDataGettersAndSetters() {
        GradeData gradeData = new GradeData();

        gradeData.setGrade(85);
        gradeData.setGrade_expected("A");
        gradeData.setGrade_msg("Great job!");
        gradeData.setObj_id(123);
        gradeData.setMark_flag(1);
        gradeData.setGrade_id("G001");
        gradeData.setWorkspace_id(456);
        gradeData.setHighlight(0);

        assertEquals(85, gradeData.getGrade());
        assertEquals("A", gradeData.getGrade_expected());
        assertEquals("Great job!", gradeData.getGrade_msg());
        assertEquals(123, gradeData.getObj_id());
        assertEquals(1, gradeData.getMark_flag());
        assertEquals("G001", gradeData.getGrade_id());
        assertEquals(456, gradeData.getWorkspace_id());
        assertEquals(0, gradeData.getHighlight());
    }
}
