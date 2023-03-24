package com.task.repository;

import com.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String email);
}
