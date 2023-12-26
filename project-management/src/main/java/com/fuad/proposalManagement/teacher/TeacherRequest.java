package com.fuad.proposalManagement.teacher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Father name is required")
    private String fatherName;
    @NotNull(message = "Mother name is required")
    private String motherName;
    @NotNull(message = "Address is required")
    private String address;
}
