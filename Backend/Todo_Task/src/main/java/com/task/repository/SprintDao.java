package com.task.repository;

import com.task.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SprintDao extends JpaRepository<Sprint,Long> {

    Optional<Sprint> findByName(String name);
}
