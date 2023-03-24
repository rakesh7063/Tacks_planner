package com.task.service;

import com.task.exception.SprintNotFoundException;
import com.task.model.Sprint;
import com.task.repository.SprintDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService{
  @Autowired
   private SprintDao sprintDao;
    @Override
    public Sprint addSprint(Sprint sprint) throws SprintNotFoundException {
       Optional<Sprint> exitingSprint = sprintDao.findByName(sprint.getName());
       if(exitingSprint.isPresent()){
           throw new SprintNotFoundException("Sprint all ready present. Please! try another name");
       }
       else return sprintDao.save(sprint);
    }
}
