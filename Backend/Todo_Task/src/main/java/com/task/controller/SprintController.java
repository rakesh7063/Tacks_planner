package com.task.controller;

import com.task.model.Sprint;
import com.task.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("daily/task")
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @PostMapping("/addSprint")
    ResponseEntity<Sprint> addSprintHandle(@Valid @RequestBody Sprint sprint, @RequestParam String key){
        return new ResponseEntity<>(sprintService.addSprint(sprint,key), HttpStatus.ACCEPTED);
    }
}
