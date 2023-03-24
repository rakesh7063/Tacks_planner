package com.task.service;

import com.task.exception.PersonNotFoundException;
import com.task.model.CurrentSession;
import com.task.model.LogDTO;
import com.task.model.User;
import com.task.repository.CurrentSessionDao;
import com.task.repository.UserDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CurrentSessionDao currentUserDao;

    @Override
    public User signUp(User user) throws PersonNotFoundException {
        Optional<User> existingUser = userDao.findByEmail(user.getEmail());
        if (existingUser.isPresent()) throw new PersonNotFoundException("please try another email..");
        return userDao.save(user);
    }

    @Override
    public String logIn(LogDTO logDTO) throws PersonNotFoundException {
        Optional<User> existingUser = userDao.findByEmail(logDTO.getMail());
        User existUser = existingUser.get();
        Optional<CurrentSession> currentUser = currentUserDao.findById(existUser.getUser_id());
        if (currentUser.isPresent()) throw new PersonNotFoundException("Already Login..");
        else {
            if (existUser.getPassword().equals(logDTO.getPassword())) {

                RandomString rs = new RandomString();
                String key = rs.make(6);
                CurrentSession newUser = new CurrentSession(existUser.getUser_id(), key, true, LocalDateTime.now());
                return newUser.toString();
            } else throw new PersonNotFoundException("Incorrect Password!..");

        }
    }
}
