package com.task.service;

import com.task.exception.TaskNotFoundException;
import com.task.model.Task;
import com.task.repository.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public Task registerTask(Task task) {
       task.setTime(LocalDateTime.now());
       task.setStatus(false);
       return taskDao.save(task);
    }

    @Override
    public Task updateTask(Task task) throws TaskNotFoundException {
        taskDao.findById(task.getTask_id()).orElseThrow(()-> new TaskNotFoundException("Task not found with taskId "+ task.getTask_id()));
        return taskDao.save(task);
    }
}
