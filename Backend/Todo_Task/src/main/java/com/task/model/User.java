package com.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    @NotNull(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First name can only contain alphabets")
    @Size(min = 1, max = 10, message = "Name must be between 1 and 10 characters")
    private String name;

    @Column(unique = true)
    @NotNull(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
    @Pattern(regexp =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit")
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "assignee")
    private Set<Task> tasks;

    @OneToMany
    private List<Sprint> sprints;
}
