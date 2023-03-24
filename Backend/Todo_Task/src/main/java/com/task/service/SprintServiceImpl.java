package com.task.service;

import com.task.model.Sprint;
import com.task.repository.SprintDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintServiceImpl implements SprintService{
  @Autowired
   private SprintDao sprintDao;
    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintDao.save(sprint);
    }
}
