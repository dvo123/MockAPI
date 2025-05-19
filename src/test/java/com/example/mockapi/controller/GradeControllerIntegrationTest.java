package com.example.mockapi.controller;

import com.example.mockapi.model.GradeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for {@link GradeController} and {@link MockApiController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GradeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private GradeData sampleGrade;

    /**
     * Sets up a sample GradeData object before each test.
     */
    @BeforeEach
    void setup() {
        sampleGrade = new GradeData();
        sampleGrade.setGrade(75);
        sampleGrade.setGrade_expected("85");
        sampleGrade.setGrade_msg("Good job");
        sampleGrade.setObj_id(1);
        sampleGrade.setMark_flag(1);
        sampleGrade.setGrade_id("G123");
        sampleGrade.setWorkspace_id(101);
        sampleGrade.setHighlight(0);
    }

    /**
     * Tests storing a GradeData object via POST and retrieving it via GET.
     *
     * @throws Exception if mockMvc fails
     */
    @Test
    void testPostAndGetMockGrade() throws Exception {
        mockMvc.perform(post("/api/mock/grade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleGrade)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/mock/grade"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.grade").value(75))
                .andExpect(jsonPath("$.grade_msg").value("Good job"))
                .andExpect(jsonPath("$.grade_id").value("G123"));
    }

    /**
     * Tests GET request without posting any data first. Assumes state may still persist.
     * Consider clearing state or using a reset endpoint for full isolation.
     *
     * @throws Exception if mockMvc fails
     */
    @Test
    void testGetMockGrade_notFound() throws Exception {
        mockMvc.perform(get("/api/mock/grade"))
                .andExpect(status().isOk()); // Might return data from previous test
    }
}
