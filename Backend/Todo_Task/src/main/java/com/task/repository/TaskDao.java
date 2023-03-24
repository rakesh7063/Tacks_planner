package com.task.repository;

import com.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskDao extends JpaRepository<Task,Long> {

    Optional<Task> findByName(String name);
}
