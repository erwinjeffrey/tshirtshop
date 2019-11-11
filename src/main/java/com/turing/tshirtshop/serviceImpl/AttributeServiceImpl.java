package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.custom.AttributeCustom;
import com.turing.tshirtshop.custom.AttributeValueCustom;
import com.turing.tshirtshop.entities.Attribute;
import com.turing.tshirtshop.repositories.AttributeCustomRepository;
import com.turing.tshirtshop.repositories.AttributeRepository;
import com.turing.tshirtshop.repositories.AttributeValueRepository;
import com.turing.tshirtshop.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeCustomRepository attributeCustomRepository;

    @Autowired
    private AttributeValueRepository  attributeValueRepository;

    @Override
    @Cacheable("attributes")
    public List<AttributeValueCustom> findAllAttributeByValue(int attributeId) {
        return attributeValueRepository.findAllAttributeByValue(attributeId);
    }

    @Override
    @Cacheable("productAttributes")
    public List<AttributeCustom> findAllProductAttribute(int productId) {
        return attributeCustomRepository.findAllProductAttribute(productId);
    }
}
