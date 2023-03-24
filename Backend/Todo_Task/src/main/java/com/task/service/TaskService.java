package com.task.service;

import com.task.exception.TaskNotFoundException;
import com.task.model.Task;

public interface TaskService {
    Task registerTask(Task task);
    Task updateTask(Task task) throws TaskNotFoundException;
}
