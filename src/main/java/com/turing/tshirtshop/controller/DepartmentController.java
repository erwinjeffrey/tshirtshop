package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Department;
import com.turing.tshirtshop.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deparments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(path = "")
    public ResponseEntity<List<Department>> findAllDepartments(){
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping(path = "/{department_id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("department_id") int departmentId){
       return  ResponseEntity.ok(departmentRepository.findById(departmentId));
    }
}
