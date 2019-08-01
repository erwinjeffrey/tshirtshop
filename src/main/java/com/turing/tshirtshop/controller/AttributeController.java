package com.turing.tshirtshop.controller;

import com.turing.tshirtshop.custom.AttributeCustom;
import com.turing.tshirtshop.custom.AttributeValueCustom;
import com.turing.tshirtshop.entities.Attribute;
import com.turing.tshirtshop.repositories.AttributeRepository;
import com.turing.tshirtshop.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeService attributeService;

    @GetMapping(path = "")
    public ResponseEntity<List<Attribute>> findAllAttributes() {
        return ResponseEntity.ok(attributeRepository.findAll());
    }

    @GetMapping(path = "/{attribute_id}")
    public ResponseEntity<Attribute> findAttributeById(@PathVariable("attribute_id")int attributeId){
        return ResponseEntity.ok(attributeRepository.findById(attributeId));
    }

    /*
    This endpoint returns a list of  values for a single attribute using the attribute id
     */
    @GetMapping(path = "/values/{attribute_id}")
    public ResponseEntity<List<AttributeValueCustom>> findAllAttributeByValue(@PathVariable("attribute_id")int attributeId){
        return ResponseEntity.ok(attributeService.findAllAttributeByValue(attributeId));
    }

    /*
    This endpoint returns a list of attributes for a single product using the product id
  */
    @GetMapping(path = "/inProduct/{product_id}")
    public ResponseEntity<List<AttributeCustom>> findAllProductAttribute(@PathVariable("product_id")int productId){
        return ResponseEntity.ok(attributeService.findAllProductAttribute(productId));
    }


}