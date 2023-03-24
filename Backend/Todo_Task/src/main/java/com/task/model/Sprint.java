package com.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sprint_id;
    @NotNull(message = "Sprint name can't be null")
    @NotBlank(message = "Sprint name can't be blank")
    @NotEmpty(message = "Sprint name can't be empty")
    @Size(min = 1, max = 10, message = "Name must be between 1 and 10 characters")
    private String name;
    @NotNull(message = "Start date is required")
    private Date startDate;
    @NotNull(message = "End date is required")
    private Date endDate;
    @OneToMany(mappedBy = "sprint")
    private Set<Task> tasks;
}
