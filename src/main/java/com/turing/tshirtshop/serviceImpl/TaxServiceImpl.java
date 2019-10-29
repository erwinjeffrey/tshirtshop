package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.entities.Tax;
import com.turing.tshirtshop.repositories.TaxRepository;
import com.turing.tshirtshop.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public List<Tax> findAll() {
        return taxRepository.findAll();
    }

    @Override
    public Tax findTaxById(int taxId) {
        return taxRepository.findById(taxId).orElse(null);
    }
}
