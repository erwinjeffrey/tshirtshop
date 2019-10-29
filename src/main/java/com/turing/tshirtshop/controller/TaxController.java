package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.entities.Tax;
import com.turing.tshirtshop.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping("")
    public ResponseEntity<List<Tax>> findAll(){
        return ResponseEntity.ok(taxService.findAll());
    }

    @GetMapping("/{tax_id}")
    public ResponseEntity<Tax> findTaxById(@PathVariable("tax_id") int taxId){
        return ResponseEntity.ok(taxService.findTaxById(taxId));
    }
}
