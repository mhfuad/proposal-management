package com.fuad.proposalManagement.teacher;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private final TeacherRepository repo;

    @Override
    public List<Teacher> all() {
        return repo.findAll();
    }

    @Override
    public Teacher create(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setFatherName(request.getFatherName());
        teacher.setMotherName(request.getMotherName());
        teacher.setAddress(request.getAddress());
        return repo.save(teacher);
    }

    @Override
    public Teacher byId(Long id) {
        return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Student not found"));
    }

    @Override
    public Teacher update(Long id, TeacherRequest request) {

        Teacher teacher = repo.findById(id).get();
        teacher.setName(request.getName());
        teacher.setFatherName(request.getFatherName());
        teacher.setMotherName(request.getMotherName());
        teacher.setAddress(request.getAddress());
        return repo.save(teacher);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


}
