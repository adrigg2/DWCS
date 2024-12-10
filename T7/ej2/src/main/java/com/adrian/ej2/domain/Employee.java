package com.adrian.ej2.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Employee {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @Email(message = "Should have a valid email format")
    private String email;

    @Min(value = 18000)
    private Double salary;
    private boolean isActive;
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID", foreignKey = @ForeignKey(name = "DEPT_ID_FK"))
    private Department department;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee") // Cascade type -> When deleting an employee, al their payslips are removed
    private List<Payslip> payslips = new ArrayList<>();
}
