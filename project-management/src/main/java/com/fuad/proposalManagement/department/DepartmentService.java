package com.fuad.proposalManagement.department;

import java.util.List;

public interface DepartmentService {
    List<Department> all();

    Department create(DepartmentRequest request);

    Department byId(Long id);

    Department update(Long id, DepartmentRequest request);

    void delete(Long id);
}
