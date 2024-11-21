package com.adrian.ej2.model;

import com.adrian.ej2.domain.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {
    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String name;

    @Email(message = "Should have a valid email format")
    private String email;

    @Min(value = 18000)
    private Double salary;
    private boolean isActive;
    private Gender gender;
}
