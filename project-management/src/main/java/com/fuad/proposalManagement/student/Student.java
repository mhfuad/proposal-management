package com.fuad.proposalManagement.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuad.proposalManagement.department.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    private String fatherName;

    private String motherName;

    private String address;

    @ManyToOne
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Department department;
}
