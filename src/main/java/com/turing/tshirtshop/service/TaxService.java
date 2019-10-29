package com.turing.tshirtshop.service;

import com.turing.tshirtshop.entities.Tax;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaxService {
    List<Tax> findAll();
    Tax findTaxById(int taxId);
}
