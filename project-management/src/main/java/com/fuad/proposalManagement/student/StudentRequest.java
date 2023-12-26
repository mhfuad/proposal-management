package com.fuad.proposalManagement.student;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Father name is required")
    private String fatherName;
    @NotNull(message = "Mother name is required")
    private String motherName;
    @NotNull(message = "Address is required")
    private String address;
}
