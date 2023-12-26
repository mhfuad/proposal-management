package com.fuad.proposalManagement.department;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private DepartmentRepository repository;

    @GetMapping
    public ResponseEntity<?> all(){
        return ResponseEntity.ok(service.all());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody DepartmentRequest request, BindingResult result){
        if (result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error: result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try{
            return ResponseEntity.ok(service.create(request));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id){
        //return ResponseEntity.ok("bal");
        try{
            return ResponseEntity.ok(service.byId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartmentRequest request){
        Optional<Department> s = repository.findById(id);
        if(s.isPresent()){
            return ResponseEntity.ok(repository.save(service.update(id, request)));
        }else{
            return ResponseEntity.badRequest().body("No Student found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Optional<Department> s = repository.findById(id);
            if(s.isPresent()){
                service.delete(id);
                return ResponseEntity.ok("Delete success");
            }else{
                return ResponseEntity.badRequest().body("No Student found");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
