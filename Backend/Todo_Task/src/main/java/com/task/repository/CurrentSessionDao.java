package com.task.repository;

import com.task.model.CurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentSessionDao  extends JpaRepository<CurrentSession,Long> {
    public Optional<CurrentSession>findByUuid(String uuid);

}
