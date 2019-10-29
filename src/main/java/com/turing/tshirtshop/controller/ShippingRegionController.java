package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Shipping;
import com.turing.tshirtshop.entities.ShippingRegion;
import com.turing.tshirtshop.repositories.ShippingRegionRepository;
import com.turing.tshirtshop.repositories.ShippingRepository;
import com.turing.tshirtshop.service.ShippingRegionService;
import com.turing.tshirtshop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipping/regions")
public class ShippingRegionController {

    @Autowired
    private ShippingRegionService shippingRegionService;

    @Autowired
    private ShippingService shippingService;

    @GetMapping("")
    public ResponseEntity<List<ShippingRegion>> findShippingRegions(){
        return ResponseEntity.ok(shippingRegionService.findShippingRegions());
    }

    @GetMapping("/{shipping_region_id}")
    public ResponseEntity<List<Shipping>> findShippingsInRegion(@PathVariable("shipping_region_id") int shippingRegionId){
        return ResponseEntity.ok(shippingService.findShippingsInRegion(shippingRegionId));
    }
}
