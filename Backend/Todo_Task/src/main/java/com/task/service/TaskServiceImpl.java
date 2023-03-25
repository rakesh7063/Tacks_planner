package com.task.service;

import com.task.exception.SprintNotFoundException;
import com.task.exception.TaskNotFoundException;
import com.task.model.Sprint;
import com.task.model.Task;
import com.task.repository.CurrentSessionDao;
import com.task.repository.SprintDao;
import com.task.repository.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


import java.time.LocalDateTime;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private SprintDao sprintDao;


    @Override
    public Task registerTask(Task task,Long sprintId) throws SprintNotFoundException {
        Optional<Sprint> sprint = sprintDao.findById(sprintId);
        if(sprint.isPresent()) {
            task.setTime(LocalDate.now());


            if(task.getTime().isBefore(sprint.get().getEndDate())) {
                task.setStatus(false);
                task.setSprint(sprint.get());
                return taskDao.save(task);
            }
            else throw new SprintNotFoundException("Sprint time is over");
        }
        else throw new SprintNotFoundException("Sprint not found with sprintId "+ sprintId);
    }

    @Override
    public Task updateTask(Task task) throws TaskNotFoundException {
        taskDao.findById(task.getTask_id()).orElseThrow(()-> new TaskNotFoundException("Task not found with taskId "+ task.getTask_id()));
        return taskDao.save(task);
    }

    @Override
    public Task deleteTask(Long id) throws TaskNotFoundException {
       Task exstingTask = taskDao.findById(id).orElseThrow(()-> new TaskNotFoundException("Task Not found with task_id "+id));
       taskDao.delete(exstingTask);
       return exstingTask;
    }
}
