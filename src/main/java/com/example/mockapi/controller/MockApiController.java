package com.example.mockapi.controller;

import com.example.mockapi.model.GradeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Mock API controller to simulate receiving and serving grade data.
 */
@RestController
@RequestMapping("/api/mock")
public class MockApiController {

    private GradeData lastReceivedGradeData;

    /**
     * Endpoint to receive and store GradeData via POST request.
     *
     * @param gradeData the grade data received from the client
     * @return HTTP 200 OK if data is received
     */
    @PostMapping("/grade")
    public ResponseEntity<Void> processGrade(@RequestBody GradeData gradeData) {
        this.lastReceivedGradeData = gradeData;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve the last stored GradeData via GET request.
     *
     * @return the last received GradeData or HTTP 404 if none is stored
     */
    @GetMapping("/grade")
    public ResponseEntity<GradeData> getStoredGrade() {
        if (lastReceivedGradeData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lastReceivedGradeData, HttpStatus.OK);
    }
}
