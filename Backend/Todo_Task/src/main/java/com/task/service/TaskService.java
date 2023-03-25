package com.task.service;

import com.task.exception.SprintNotFoundException;
import com.task.exception.TaskNotFoundException;
import com.task.model.Task;

public interface TaskService {
    Task registerTask(Task task,Long sprintId) throws SprintNotFoundException;
    Task updateTask(Task task) throws TaskNotFoundException;
    Task deleteTask(Long id) throws TaskNotFoundException;

}
