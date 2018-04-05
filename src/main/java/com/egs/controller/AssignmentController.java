package com.egs.controller;

import com.egs.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hayk_Mkhitaryan
 */
@RestController
public class AssignmentController {

    @SuppressWarnings("unchecked")
    @PutMapping("assignment/users/{repId}")
    public ResponseEntity assignTask(@RequestBody Task task) {

        return new ResponseEntity(task, HttpStatus.OK);
    }
}
