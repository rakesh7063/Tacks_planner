package com.task.controller;

import com.task.model.Sprint;
import com.task.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("daily/task")
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @PostMapping("/addSprint")
    ResponseEntity<Sprint> addSprintHandle(@Valid @RequestBody Sprint sprint){
        return new ResponseEntity<>(sprintService.addSprint(sprint), HttpStatus.ACCEPTED);
    }
}
