package com.example.mockapi.controller;

import com.example.mockapi.model.ApiResponse;
import com.example.mockapi.model.GradeData;
import com.example.mockapi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for handling requests to retrieve grade data.
 */
@RestController
@RequestMapping("/api/v1")
public class GradeController {

    private final GradeService gradeService;

    /**
     * Constructs a new GradeController with the given GradeService.
     *
     * @param gradeService the service used to fetch grade data
     */
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Handles GET requests to retrieve grade data.
     *
     * @return an ApiResponse containing GradeData or error info
     */
    @GetMapping("/grade")
    public ApiResponse<GradeData> getGrade() {
        return gradeService.getGradeData();
    }
}
