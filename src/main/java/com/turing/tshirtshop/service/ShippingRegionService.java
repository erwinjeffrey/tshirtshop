package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.ShippingRegion;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShippingRegionService {
    List<ShippingRegion> findShippingRegions();
}
