package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    List<Department>  findAll();
    Department findById(int departmentId);
}
