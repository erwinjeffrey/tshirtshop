package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.entities.ShippingRegion;
import com.turing.tshirtshop.repositories.ShippingRegionRepository;
import com.turing.tshirtshop.service.ShippingRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingRegionServiceImpl implements ShippingRegionService {

    @Autowired
    private ShippingRegionRepository shippingRegionRepository;

    @Override
    @Cacheable("shippingRegions")
    public List<ShippingRegion> findShippingRegions() {
        return shippingRegionRepository.findShippingRegions();
    }
}
