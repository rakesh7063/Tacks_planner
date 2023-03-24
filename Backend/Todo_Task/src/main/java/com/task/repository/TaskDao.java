package com.task.repository;

import com.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task,Long> {
}
