package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping,Integer> {
}
