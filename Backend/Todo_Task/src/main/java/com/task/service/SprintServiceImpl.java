package com.task.service;

import com.task.exception.LogInException;
import com.task.exception.SprintNotFoundException;
import com.task.model.CurrentSession;
import com.task.model.Sprint;
import com.task.model.User;
import com.task.repository.CurrentSessionDao;
import com.task.repository.SprintDao;
import com.task.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService {
    @Autowired
    private SprintDao sprintDao;
    @Autowired
    private CurrentSessionDao currentUserDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Sprint addSprint(Sprint sprint, String key) throws SprintNotFoundException, LogInException {
        Optional<CurrentSession> existingUser = currentUserDao.findByUuid(key);
        if (existingUser.isEmpty()) throw new LogInException("Please log in first..");
        else return sprintDao.save(sprint);

    }
}
