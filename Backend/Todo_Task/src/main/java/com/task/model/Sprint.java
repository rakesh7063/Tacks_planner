package com.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
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
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First name can only contain alphabets")
    private String name;
    @NotNull(message = "Start date is required")
    private Date startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sprint")
    private Set<Task> tasks;
}
