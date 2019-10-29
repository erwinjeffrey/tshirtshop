package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Integer> {

}
