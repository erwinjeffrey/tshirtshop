package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.entities.Shipping;
import com.turing.tshirtshop.repositories.ShippingRegionRepository;
import com.turing.tshirtshop.repositories.ShippingRepository;
import com.turing.tshirtshop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public List<Shipping> findShippingsInRegion(int shippingRegionId) {
        return shippingRepository.findAll();
    }
}
