package com.task.controller;

import com.task.model.Task;
import com.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/daily_task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    ResponseEntity<Task> registerTaskHandle(@Valid @RequestBody Task task){
        return new ResponseEntity<>(taskService.registerTask(task), HttpStatus.ACCEPTED);
    }
    @PutMapping("/updateTask")
    ResponseEntity<Task> updateTaskHandle(@Valid @RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
    }
    @DeleteMapping("/deleteTask/id")
    ResponseEntity<Task> deleteTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
    }
}
