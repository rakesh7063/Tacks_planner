package com.task.service;

import com.task.exception.PersonNotFoundException;
import com.task.model.LogDTO;
import com.task.model.User;

public interface UserService {
    public User signUp(User user) throws PersonNotFoundException;
    public String logIn(LogDTO logDTO) throws PersonNotFoundException;
}
