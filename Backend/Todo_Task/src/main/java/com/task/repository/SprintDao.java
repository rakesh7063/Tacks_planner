package com.task.repository;

import com.task.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintDao extends JpaRepository<Sprint,Long> {

}
