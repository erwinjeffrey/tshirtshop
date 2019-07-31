package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute,Integer> {
    List<Attribute> findAll();

    Attribute findById(int id);
}
