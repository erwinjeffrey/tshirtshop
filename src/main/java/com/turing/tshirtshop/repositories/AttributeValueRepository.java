package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.AttributeCustom;
import com.turing.tshirtshop.custom.AttributeValueCustom;
import com.turing.tshirtshop.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttributeValueRepository extends JpaRepository<AttributeValueCustom, Integer> {
    @Query(nativeQuery = true, value = "call catalog_get_attribute_values(:inAttributeId)")
    List<AttributeValueCustom> findAllAttributeByValue(@Param("inAttributeId") int attributeId);
}
