package com.task.service;

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
}
