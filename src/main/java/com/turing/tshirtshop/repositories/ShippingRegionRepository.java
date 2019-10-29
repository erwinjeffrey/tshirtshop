package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.ShippingRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingRegionRepository extends JpaRepository<ShippingRegion, Integer> {

    @Query(nativeQuery = true, value = "call customer_get_shipping_regions()")
    List<ShippingRegion> findShippingRegions();
}
