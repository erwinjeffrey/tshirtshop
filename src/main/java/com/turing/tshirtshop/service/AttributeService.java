package com.turing.tshirtshop.service;

import com.turing.tshirtshop.custom.AttributeCustom;
import com.turing.tshirtshop.custom.AttributeValueCustom;
import com.turing.tshirtshop.entities.Attribute;

import java.util.List;

public interface AttributeService {
    List<AttributeValueCustom> findAllAttributeByValue(int attributeId);
    List<AttributeCustom>findAllProductAttribute(int productId);
}
