package com.fuad.proposalManagement.student;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository repo;


    @Override
    public List<Student> all() {
        return repo.findAll();
    }

    @Override
    public Student create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setFatherName(request.getFatherName());
        student.setMotherName(request.getMotherName());
        student.setAddress(request.getAddress());
        return repo.save(student);
    }

    @Override
    public Student byId(Long id) {
        return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Student not found"));
    }

    @Override
    public Student update(Long id, StudentRequest request) {

        Student student = repo.findById(id).get();
        student.setName(request.getName());
        student.setFatherName(request.getFatherName());
        student.setMotherName(request.getMotherName());
        student.setAddress(request.getAddress());
        return repo.save(student);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


}
