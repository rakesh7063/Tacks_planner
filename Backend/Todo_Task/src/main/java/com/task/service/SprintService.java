package com.task.service;

import com.task.exception.LogInException;
import com.task.exception.SprintNotFoundException;
import com.task.model.Sprint;

public interface SprintService {
    public Sprint addSprint(Sprint sprint, String key) throws SprintNotFoundException, LogInException;
}
