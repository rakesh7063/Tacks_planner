package com.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentSession {
    @Id
    @Column(unique = true)
    private Long userId;

    private String uuid;

    private Boolean user;

    private LocalDateTime timestamp;
}
