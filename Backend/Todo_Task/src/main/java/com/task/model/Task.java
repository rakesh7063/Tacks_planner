package com.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long task_id;
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name can't be Blank")
    @NotEmpty(message = "Name can't be empty")
    @Size(min = 1, max = 10, message = "Name must be between 1 and 10 characters")
    private String name;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 1000, message = "Description must be between 1 and 1000 characters")
    private String description;
    @Enumerated
    private Type type;
    @NotNull(message = "Status is required")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
}
