package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.Shipping;

import java.util.List;

public interface ShippingService {
    List<Shipping> findShippingsInRegion(int shippingRegionId);
}
